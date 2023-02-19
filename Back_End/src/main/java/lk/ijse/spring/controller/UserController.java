package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.impl.UserServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //    @PostMapping
//    public ResponseUtil saveUser(UserDTO userDTO) {
//
//        userService.saveUser(userDTO);
//
//        return new ResponseUtil("Ok", "Successfully Saved", null);
//    }
    @PostMapping
    public RedirectView saveUser(UserDTO userDTO){

        userService.saveUser(userDTO);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:63342/Car_Rental_System/Front_End/index.html");

        return redirectView;
    }

}
