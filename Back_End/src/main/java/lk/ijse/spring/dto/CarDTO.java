package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    @Id
    private String regNo;
    private String carModel;
    private String carType;
    private String carTransmission;
    private String fuelType;
    private String carColor;
    private int passenger;
    private double lossDamage;
    private double dailyRate;
    private double monthlyRate;
    private double extraKm;
    private String carImage;
    private String available="good";
    private String status="Active";
}
