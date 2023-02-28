package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String regNo;
    private String carModel;
    private String carType;
    private String carTransmission;
    private String fuelType;
    private String carColor;
    private int qty;
    private int passenger;
    private double lossDamage;
    private double dailyRate;
    private double monthlyRate;
    private double extraKm;
    private String carImage;
    private String carImageUrl;
    private String available;
    private String status;

    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Reservation> resList = new ArrayList<>();
}
