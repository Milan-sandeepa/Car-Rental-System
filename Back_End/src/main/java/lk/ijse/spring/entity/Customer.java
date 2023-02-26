package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
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
}
