package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.impl.CarServiceImpl;
import lk.ijse.spring.service.impl.CustomerServiceImpl;
import lk.ijse.spring.service.impl.DriverServiceImpl;
import lk.ijse.spring.service.impl.UserServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    DriverServiceImpl driverService;

    private String logId;

    @PostMapping
    public ResponseUtil saveUser() {
        System.out.println("Received request");
        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @PostMapping(params ={"id"})
    public ResponseUtil setUserDetails(String id) {
        System.out.println("Received request now "+id);
        logId=id;
        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @GetMapping
    public ResponseUtil getUser() {
        return new ResponseUtil("Ok", "Successfully Loaded", userService.getAllUser());
    }

    @GetMapping(path = "/user")
    public ResponseUtil getUserDetails() {
        DriverDTO driverDTO = driverService.searchDriverWithId(logId);
        System.out.println(driverDTO);
        return new ResponseUtil("Ok", "Successfully Loaded", driverDTO);
    }
}
