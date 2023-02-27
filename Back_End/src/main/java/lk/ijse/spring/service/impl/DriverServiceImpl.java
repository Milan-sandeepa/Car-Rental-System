package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDriverID())) {
            throw new RuntimeException("Driver already exists");
        }

        Driver map = mapper.map(driverDTO, Driver.class);
        driverRepo.save(map);
    }

    @Override
    public void deleteDriver(String id) {
        if (!driverRepo.existsById(id)) {
            throw new RuntimeException("Driver Not exists.Please enter valid Id");
        }
        driverRepo.deleteById(id);
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if (!driverRepo.existsById(driverDTO.getDriverID())) {
            throw new RuntimeException("Driver Not exists.Please enter valid Id");
        }
        Driver map = mapper.map(driverDTO, Driver.class);
        driverRepo.save(map);
    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        ArrayList<DriverDTO> allList=mapper.map(driverRepo.findAll(),new TypeToken<ArrayList<DriverDTO>>(){}.getType());
        return allList;
    }

    @Override
    public DriverDTO searchDriverWithId(String id) {
        return mapper.map(driverRepo.findById(id),DriverDTO.class);
    }
}
