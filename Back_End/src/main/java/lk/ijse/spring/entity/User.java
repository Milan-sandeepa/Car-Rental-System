package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sun.security.util.Password;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
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
