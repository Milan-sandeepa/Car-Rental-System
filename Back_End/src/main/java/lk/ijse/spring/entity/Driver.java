package lk.ijse.spring.entity;

import lk.ijse.spring.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "driver")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {
    @Id
    private String driverID;
    private String name;
    private String licenseNo;
    private String address;
    private String gender;
    private String contact;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER ,cascade = CascadeType.DETACH)
    private List<Reservation> resList = new ArrayList<>();
}
