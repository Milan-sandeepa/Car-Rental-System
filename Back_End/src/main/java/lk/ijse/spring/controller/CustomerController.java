package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
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

            UserDTO userDTO = new UserDTO(customerDTO.getNicNo(),customerDTO.getName(), customerDTO.getUserPwd(), "User");
            userService.saveUser(userDTO);

            customerDTO.setUserDTO(userDTO);

            customerService.saveCustomer(customerDTO);



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
        CustomerDTO customerDTO1 = customerService.searchCustomerWithNic(customerDTO.getNicNo());
        String nic_photo = customerDTO1.getNic_Photo();
        customerDTO.setNic_Photo(nic_photo);

        customerService.updateCustomer(customerDTO);
        return new ResponseUtil("Ok", customerDTO.getNicNo() + " Successfully Updated", null);
    }

    @PostMapping(path = "/status")
    public ResponseUtil updateCustomerStatus(@RequestPart("nic/licenseNo")String id,@RequestPart("status") String status) {
        CustomerDTO customerDTO1 = customerService.searchCustomerWithNic(id);
        customerDTO1.setStatus(status);

        customerService.updateCustomer(customerDTO1);

        System.out.println(id+status);
        return new ResponseUtil("Ok", customerDTO1.getNicNo() + " Successfully Updated", null);
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(String id) {
        userService.deleteUser(id);
        customerService.deleteCustomer(id);
        return new ResponseUtil("Ok", id + " Successfully Deleted", null);
    }

    @GetMapping(path = "/search")
    public ResponseUtil searchCustomerByNic(@RequestParam String nicNo){
        System.out.println(nicNo);
        return new ResponseUtil("OK","Successfully Loaded. :" ,customerService.searchCustomerWithNic(nicNo));
    }

    @GetMapping(path = "/count")
    public ResponseUtil getCustomerCount() {
        return new ResponseUtil("Ok", "Successfully Loaded", customerService.countCustomer());
    }
}
