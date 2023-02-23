package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import sun.security.util.Password;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserDTO {

    private String name;
    private String gender;
    private String address;
    private String contact;
    @Id
    private String email;
    private String nicNo;
    private String nicPhoto;
    private String licenseNo;
    private String licensePhoto;
    private String userPwd;
}
