package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ReservationDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Reservation;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ReservationRepo;
import lk.ijse.spring.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveReservation(ReservationDTO reservationDTO) {
        if (repo.existsById(reservationDTO.getResId())) {
            throw new RuntimeException("Reservation already exists");
        }

        Reservation map = mapper.map(reservationDTO, Reservation.class);
        repo.save(map);
    }

    @Override
    public void deleteReservation(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Reservation Not exists.Please enter valid Id");
        }

        repo.deleteById(id);
    }

    @Override
    public void updateReservation(ReservationDTO reservationDTO) {
        if (!repo.existsById(reservationDTO.getResId())) {
            throw new RuntimeException("Reservation Not exists.Please enter valid Id");
        }


        Reservation map = mapper.map(reservationDTO, Reservation.class);
        repo.save(map);
    }

    @Override
    public ArrayList<ReservationDTO> getAllReservation() {
        ArrayList<ReservationDTO> allList=mapper.map(repo.findAll(),new TypeToken<ArrayList<ReservationDTO>>(){}.getType());
        return allList;
    }

    @Override
    public ReservationDTO searchReservationWithId(String id) {
        return mapper.map(repo.findById(id),ReservationDTO.class);
    }
}
