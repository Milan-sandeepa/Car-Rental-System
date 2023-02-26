package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.impl.UserServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.hibernate.boot.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import sun.text.resources.FormatData;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.Normalizer;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseUtil getUser() {
        return new ResponseUtil("Ok", "Successfully Loaded", null);
    }
//
//    @Autowired
//    UserServiceImpl userService;
////
//////    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
////    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
////    public ResponseUtil saveUser(@RequestPart("name") String name,@RequestPart("gender") String gender, @RequestPart("address") String address,
////                                 @RequestPart("contact") String contact, @RequestPart("email") String email, @RequestPart("nic/licenseNo") String nicNo,
////                                 @RequestPart("pass") String pass,
////                                 @RequestPart("nic/licensePhoto") MultipartFile file1) {
////
////
////        System.out.println(name+"-"+gender+"-"+address+"-"+contact+"-"+email+"-"+nicNo+"-"+"-"+pass);
////        System.out.println(file1);
////        String role="guest";
////        String status="Not Active";
////
////        try {
////            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
////            File uploadsDir = new File(projectPath + "/uploads");
//////            System.out.println(projectPath);
////            uploadsDir.mkdir();
////            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));
////
////            UserDTO userDTO = new UserDTO(name,gender,address,contact,email,nicNo,"uploads/"+file1.getOriginalFilename(),pass,role,status);
////            userService.saveUser(userDTO);
////
////        } catch (IOException | URISyntaxException e) {
////            e.printStackTrace();
////            return new ResponseUtil("Ok", "Successfully Saved", null);
////        }
////
////        return new ResponseUtil("Ok", "Successfully Saved", null);
////    }
//
//    @GetMapping
//    public ResponseUtil getCustomer() {
//
//        return new ResponseUtil("Ok", "Successfully Loaded", userService.getAllUser());
//    }
//
//    @PutMapping
//    public ResponseUtil updateCustomer(@RequestBody UserDTO userDTO) {
//
//        userService.updateUser(userDTO);
//        return new ResponseUtil("Ok", userDTO.getEmail() + " Successfully Updated", null);
//    }
//
//    @DeleteMapping
//    public ResponseUtil deleteCustomer(String id) {
//        userService.deleteUser(id);
//        return new ResponseUtil("Ok", id + " Successfully Deleted", null);
//    }
}
