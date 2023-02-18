package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sun.security.util.Password;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserDTO {

    private String name;
    private String contact;
    private String address;
    @Id
    private String email;
    private String nicNo;
    private String userPwd;
}
