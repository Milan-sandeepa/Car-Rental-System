package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
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
    private MultipartFile carImage;
    private String carImageUrl;
    private String available="Available";
    private String status="Active";

}
