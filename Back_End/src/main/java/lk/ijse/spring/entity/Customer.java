package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "customer")
public class Customer {
    @Id
    private String nicNo;
    private String name;
    private String gender;
    private String address;
    private String contact;
    private String email;
    private String nic_Photo;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    private List<Reservation> resList;

    public Customer(String nicNo,String name,String gender,String address,String contact,String email,String nic_Photo,User user){
        this.nicNo=nicNo;
        this.name=name;
        this.gender=gender;
        this.address=address;
        this.contact=contact;
        this.email=email;
        this.nic_Photo=nic_Photo;
        this.user=user;
    }
}
