package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "reservation")
public class Reservation {
    @Id
    private String resId;
    private String pickDate;
    private String returnDate;
    private int qty;
    private double total;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nicNo",referencedColumnName = "nicNo",insertable = true,updatable = true)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regNo",referencedColumnName = "regNo",insertable = true,updatable = true)
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverID",referencedColumnName = "driverID",insertable = true,updatable = true)
    private Driver driver;
}
