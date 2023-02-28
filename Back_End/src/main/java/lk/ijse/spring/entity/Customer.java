package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {
    @Id
    private String nicNo;
    private String name;
    private String gender;
    private String address;
    private String contact;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private String nicImage;
    private String nic_Photo;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Reservation> resList = new ArrayList<>();
}
