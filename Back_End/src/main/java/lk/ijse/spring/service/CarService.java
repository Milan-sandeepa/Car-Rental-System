package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.UserDTO;

import java.util.ArrayList;

public interface CarService {
    public void saveCar(CarDTO carDTO);

    public void deleteCar(String id);

    public void updateCar(CarDTO carDTO);

    public ArrayList<CarDTO> getAllCar();

    public CarDTO searchCarWithRegNo(String id);
}
