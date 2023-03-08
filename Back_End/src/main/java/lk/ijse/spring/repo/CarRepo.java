package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car,String> {
    @Query(value = "SELECT COUNT(*) FROM car ",nativeQuery = true)
    int countCar();

    @Query(value = "SELECT regNo FROM car ORDER BY regNo DESC LIMIT 1",nativeQuery = true)
    String generatedCarId();
}
