package lk.ijse.spring.controller;

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

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil saveUser(@RequestPart("name") String name,
                                 @RequestPart("gender") String gender,
                                 @RequestPart("address") String address,
                                 @RequestPart("contact") String contact,
                                 @RequestPart("email") String email,
                                 @RequestPart("nicNo") String nicNo,
                                 @RequestPart("licenseNo") String licenseNo,
                                 @RequestPart("pass") String pass,
                                 @RequestPart("nicPhoto") MultipartFile file1, @RequestPart("licencePhoto") MultipartFile file2) {


        System.out.println(name+"-"+gender+"-"+address+"-"+contact+"-"+email+"-"+nicNo+"-"+licenseNo+"-"+pass);
        System.out.println(file1);
        System.out.println(file2);

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();
            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));
            file2.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file2.getOriginalFilename()));

            UserDTO userDTO = new UserDTO(name,gender,address,contact,email,nicNo,"uploads/"+file1.getOriginalFilename(),licenseNo,"uploads/"+file2.getOriginalFilename(),pass);
            userService.saveUser(userDTO);

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Successfully Saved", null);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }

        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @GetMapping
    public ResponseUtil getCustomer() {

        return new ResponseUtil("Ok", "Successfully Loaded", userService.getAllUser());
    }
}
