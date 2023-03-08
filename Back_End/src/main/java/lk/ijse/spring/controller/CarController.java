package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.impl.CarServiceImpl;
import lk.ijse.spring.service.impl.UserServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarServiceImpl carService;

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseUtil saveCar(CarDTO carDTO,@RequestPart("carImage") MultipartFile file1) {

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
//            System.out.println(projectPath);
            uploadsDir.mkdir();
            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));

            carDTO.setCarImageUrl("uploads/"+file1.getOriginalFilename());
            carService.saveCar(carDTO);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }

        System.out.println(carDTO);
        return new ResponseUtil("Ok", "Successfully Saved", null);

    }

    @GetMapping
    public ResponseUtil getCar() {
        return new ResponseUtil("Ok", "Successfully Loaded", carService.getAllCar());
    }

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO carDTO) {
        CarDTO carDTO1 = carService.searchCarWithRegNo(carDTO.getRegNo());
        String carImageUrl = carDTO1.getCarImageUrl();
        carDTO.setCarImageUrl(carImageUrl);
        carService.updateCar(carDTO);
        return new ResponseUtil("Ok", carDTO.getRegNo() + " Successfully Updated", null);
    }

    @DeleteMapping
    public ResponseUtil deleteCar(String id) {
        carService.deleteCar(id);
        return new ResponseUtil("Ok", id + " Successfully Deleted", null);
    }

    @GetMapping(path = "/{regNo}")
    public ResponseUtil searchCarByName(@PathVariable String regNo){
        return new ResponseUtil("OK","Successfully Loaded. :" ,carService.searchCarWithRegNo(regNo));
    }

    @GetMapping(path = "/count")
    public ResponseUtil getCarCount() {
        return new ResponseUtil("Ok", "Successfully Loaded", carService.countCar());
    }

    @GetMapping(path = "/gererateId")
    public ResponseUtil generateCarId() {

        return new ResponseUtil("Ok", "Successfully Generated", carService.generateCarId());
    }
}
