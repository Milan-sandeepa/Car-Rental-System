package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.impl.CustomerServiceImpl;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    UserServiceImpl userService;

    //    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseUtil saveCustomer(CustomerDTO customerDTO, @RequestPart("nic/licensePhoto") MultipartFile file1) {

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");

            uploadsDir.mkdir();
            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));

            customerDTO.setNic_Photo("uploads/"+file1.getOriginalFilename());

            customerService.saveCustomer(customerDTO);

            UserDTO userDTO = new UserDTO(customerDTO.getName(), customerDTO.getUserPwd(), "Guest");

            userService.saveUser(userDTO);

            System.out.println(userDTO);


        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }

        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @GetMapping
    public ResponseUtil getCustomer() {

        return new ResponseUtil("Ok", "Successfully Loaded", customerService.getAllCustomer());
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {

        customerService.updateCustomer(customerDTO);
        return new ResponseUtil("Ok", customerDTO.getNicNo() + " Successfully Updated", null);
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(String id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil("Ok", id + " Successfully Deleted", null);
    }
}
