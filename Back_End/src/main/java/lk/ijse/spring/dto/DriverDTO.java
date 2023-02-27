package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class DriverDTO {
    @Id
    private String driverID;
    private String name;
    private String licenseNo;
    private String address;
    private String gender;
    private String contact;
    private String email;
    private String password;

}
