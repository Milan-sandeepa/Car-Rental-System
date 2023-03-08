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
    private String nic;
    private String username;
    private String password;
    private String role;
}
