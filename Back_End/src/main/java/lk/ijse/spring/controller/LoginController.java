package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.impl.CarServiceImpl;
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

    @PostMapping
    public ResponseUtil saveUser() {
        System.out.println("Received request");
        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @GetMapping
    public ResponseUtil getUser() {
        return new ResponseUtil("Ok", "Successfully Loaded", userService.getAllUser());
    }
}
