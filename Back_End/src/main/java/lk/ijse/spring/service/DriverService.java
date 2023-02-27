package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    public void saveDriver(DriverDTO driverDTO);

    public void deleteDriver(String id);

    public void updateDriver(DriverDTO driverDTO);

    public ArrayList<DriverDTO> getAllDriver();

    public DriverDTO searchDriverWithId(String id);
}
