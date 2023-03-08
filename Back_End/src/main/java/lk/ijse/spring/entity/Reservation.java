package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;

@Transactional
@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@ToString
@Getter
@Setter
@Entity(name = "reservation")
public class Reservation {
    @Id
    private String resId;
    private String pickDate;
    private String returnDate;
    private double total;
    private String status;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "nicNo",referencedColumnName = "nicNo",insertable = true,updatable = true)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regNo",referencedColumnName = "regNo",insertable = true,updatable = true)
    @JsonIgnore
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverID",referencedColumnName = "driverID",insertable = true,updatable = true)
    @JsonIgnore
    private Driver driver;
}
