package lk.ijse.spring.repo;

import lk.ijse.spring.dto.ReservationDTO;
import lk.ijse.spring.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepo extends JpaRepository<Reservation,String> {
    @Query(value = "SELECT resId FROM reservation ORDER BY resId DESC LIMIT 1",nativeQuery = true)
    String generatedResId();

    @Query(value = "SELECT COUNT(*) FROM reservation ",nativeQuery = true)
    int countReservation();
}
