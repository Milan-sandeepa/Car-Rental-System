package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.impl.CustomerServiceImpl;
import lk.ijse.spring.service.impl.DriverServiceImpl;
import lk.ijse.spring.service.impl.UserServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverServiceImpl driverService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping
    public ResponseUtil saveDriver(DriverDTO driverDTO) {

        System.out.println(driverDTO);
        UserDTO userDTO = new UserDTO(driverDTO.getDriverID(),driverDTO.getDriverID(), driverDTO.getPassword(), "Driver");
        userService.saveUser(userDTO);
        driverService.saveDriver(driverDTO);

        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @GetMapping
    public ResponseUtil getDriver() {

        return new ResponseUtil("Ok", "Successfully Loaded", driverService.getAllDriver());
    }

    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO driverDTO) {

        driverService.updateDriver(driverDTO);
        return new ResponseUtil("Ok", driverDTO.getDriverID() + " Successfully Updated", null);
    }

    @DeleteMapping
    public ResponseUtil deleteDriver(String id) {
        userService.deleteUser(id);
        driverService.deleteDriver(id);
        return new ResponseUtil("Ok", id + " Successfully Deleted", null);
    }
}
