package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO carDTO) {
        if (carRepo.existsById(carDTO.getRegNo())) {
            throw new RuntimeException("User already exists");
        }

        Car map = mapper.map(carDTO, Car.class);
        carRepo.save(map);
    }

    @Override
    public void deleteCar(String id) {
        if (!carRepo.existsById(id)) {
            throw new RuntimeException("Car Not exists.Please enter valid Id");
        }
        carRepo.deleteById(id);
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        if (!carRepo.existsById(carDTO.getRegNo())) {
            throw new RuntimeException("Car Not exists.Please enter valid Id");
        }


        Car map = mapper.map(carDTO, Car.class);
        carRepo.save(map);
    }

    @Override
    public ArrayList<CarDTO> getAllCar() {
        ArrayList<CarDTO> allList=mapper.map(carRepo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
        return allList;
    }

    @Override
    public CarDTO searchCarWithRegNo(String id) {
        return mapper.map(carRepo.findById(id),CarDTO.class);
    }
}
