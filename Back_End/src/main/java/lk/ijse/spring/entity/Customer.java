package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
//@Data
//@ToString
@Getter
@Setter
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
    private String status;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private User user;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER ,cascade = CascadeType.DETACH)
    private List<Reservation> resList;

    public Customer(String nicNo,String name,String gender,String address,String contact,String email,String nic_Photo,String status,User user){
        this.nicNo=nicNo;
        this.name=name;
        this.gender=gender;
        this.address=address;
        this.contact=contact;
        this.email=email;
        this.nic_Photo=nic_Photo;
        this.status=status;
        this.user=user;
    }
}
