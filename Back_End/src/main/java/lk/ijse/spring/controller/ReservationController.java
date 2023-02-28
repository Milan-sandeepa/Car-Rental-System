package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ReservationDTO;
import lk.ijse.spring.service.impl.CustomerServiceImpl;
import lk.ijse.spring.service.impl.ReservationServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationServiceImpl reservationService;

    @PostMapping
    public ResponseUtil saveReservation(@RequestBody ReservationDTO reservationDTO) {
        System.out.println(reservationDTO);
        reservationService.saveReservation(reservationDTO);
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
}
