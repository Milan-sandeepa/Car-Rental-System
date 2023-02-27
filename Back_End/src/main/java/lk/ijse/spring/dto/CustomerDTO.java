package lk.ijse.spring.dto;

import lk.ijse.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    @Id
    private String nicNo;
    private String name;
    private String gender;
    private String address;
    private String contact;
    private String email;

    private MultipartFile nic_licensePhoto;
    private String nic_Photo;

    private String userPwd;

    private UserDTO userDTO;

}
