package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ReservationDTO;

import java.util.ArrayList;

public interface ReservationService {
    public void saveReservation(ReservationDTO reservationDTO);

    public void deleteReservation(String id);

    public void updateReservation(ReservationDTO reservationDTO);

    public ArrayList<ReservationDTO> getAllReservation();

    public ReservationDTO searchReservationWithId(String id);

    public String generateResId();

    public int countReservation();
}
