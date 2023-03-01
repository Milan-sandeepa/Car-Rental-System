package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.ReservationDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.service.impl.CarServiceImpl;
import lk.ijse.spring.service.impl.CustomerServiceImpl;
import lk.ijse.spring.service.impl.DriverServiceImpl;
import lk.ijse.spring.service.impl.ReservationServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    private ModelMapper mapper;

    @PostMapping
    public ResponseUtil saveReservation(ReservationDTO reservationDTO,@RequestPart("cusId") String cid,@RequestPart("carId") String carId,@RequestPart("driverID") String driverId) {
        CustomerDTO customerDTO = customerService.searchCustomerWithNic(cid);
        System.out.println(customerDTO);
        CarDTO carDTO = carService.searchCarWithRegNo(carId);
        System.out.println(carDTO);

        Customer map1 = mapper.map(customerDTO, Customer.class);
        Car map2 = mapper.map(carDTO, Car.class);

        if (driverId.equals("0000")){
            reservationDTO.setCustomer(map1);
            reservationDTO.setCar(map2);
            reservationService.saveReservation(reservationDTO);
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }
        DriverDTO driverDTO = driverService.searchDriverWithId(driverId);
        System.out.println(driverDTO);


        Driver map3 = mapper.map(driverDTO, Driver.class);

        reservationDTO.setCustomer(map1);
        reservationDTO.setCar(map2);
        reservationDTO.setDriver(map3);

        reservationService.saveReservation(reservationDTO);
        System.out.println(reservationDTO);
        System.out.println(driverId);
        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @GetMapping
    public ResponseUtil getReservation() {

        return new ResponseUtil("Ok", "Successfully Loaded", reservationService.getAllReservation());
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
