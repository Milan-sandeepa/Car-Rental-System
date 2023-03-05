package lk.ijse.spring.controller;

import lk.ijse.spring.dto.*;
import lk.ijse.spring.entity.*;
import lk.ijse.spring.service.impl.*;
import lk.ijse.spring.util.ResponseUtil;
import org.hibernate.LazyInitializationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    CarServiceImpl carService;

    @Autowired
    DriverServiceImpl driverService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseUtil saveReservation(ReservationDTO reservationDTO,@RequestPart("cusId") String cid,@RequestPart("carId") String carId,@RequestPart("driverID") String driverId) {
        CustomerDTO customerDTO = customerService.searchCustomerWithNic(cid);
        CarDTO carDTO = carService.searchCarWithRegNo(carId);

        UserDTO userDTO = userService.searchUserWithNic(customerDTO.getNicNo());

//        Customer map1 = mapper.map(customerDTO, Customer.class);
        User map = mapper.map(userDTO, User.class);
        Customer customer = new Customer(customerDTO.getNicNo(),customerDTO.getName(),customerDTO.getGender(),customerDTO.getAddress(),customerDTO.getContact(),customerDTO.getEmail(),customerDTO.getNic_Photo(),map);
        Car map2 = mapper.map(carDTO, Car.class);

        if (driverId.equals("0000")){
//            reservationDTO.setCustomer(map1);
            reservationDTO.setCustomer(customer);
            reservationDTO.setCar(map2);
            reservationService.saveReservation(reservationDTO);
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }
        DriverDTO driverDTO = driverService.searchDriverWithId(driverId);
        System.out.println(driverDTO);


        Driver map3 = mapper.map(driverDTO, Driver.class);

//        reservationDTO.setCustomer(map1);
        reservationDTO.setCustomer(customer);
        reservationDTO.setCar(map2);
        reservationDTO.setDriver(map3);

        reservationService.saveReservation(reservationDTO);
        System.out.println(reservationDTO);
        System.out.println(driverId);
        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @GetMapping
    public ResponseUtil getReservation() {
        List<ReservationDTO> reservationDTOList = new ArrayList<>();
        ArrayList<ReservationDTO> reservations = reservationService.getAllReservation();

        try {
            for (ReservationDTO reservation : reservations) {
                Customer customer = reservation.getCustomer();
                Car car = reservation.getCar();
                Driver driver = reservation.getDriver();
                reservationDTOList.add(new ReservationDTO(reservation.getResId(),reservation.getPickDate(),reservation.getReturnDate(),reservation.getTotal(),reservation.getStatus(),customer,car,driver));
            }
        } catch (LazyInitializationException e) {
            return new ResponseUtil("Error", "Failed to initialize resList", null);
        }

        return new ResponseUtil("Ok", "Successfully Loaded", reservationDTOList);
    }

    @PutMapping
    public ResponseUtil updateReservation(@RequestBody ReservationDTO reservationDTO) {

        reservationService.updateReservation(reservationDTO);
        return new ResponseUtil("Ok", reservationDTO.getResId() + " Successfully Updated", null);
    }

    @DeleteMapping
    public ResponseUtil deleteReservation(String id) {
        reservationService.deleteReservation(id);
        return new ResponseUtil("Ok", id + " Successfully Deleted", null);
    }

//    @GetMapping(path = "/search")
//    public ResponseUtil getReservationWithId(String rId) {
//        System.out.println("wade hari  "+rId);
//        return new ResponseUtil("Ok", "Successfully Loaded", reservationService.searchReservationWithId(rId));
//    }
}
