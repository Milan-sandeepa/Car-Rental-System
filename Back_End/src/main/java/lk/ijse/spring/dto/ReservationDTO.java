package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReservationDTO {
    @Id
    private String resId;
    private String pickDate;
    private String returnDate;
    private int qty;
    private double total;
    private String status="pending";

    private Customer customer;
    private Car car;
    private Driver driver;
}
