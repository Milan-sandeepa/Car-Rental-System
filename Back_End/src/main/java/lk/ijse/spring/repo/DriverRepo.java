package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "SELECT COUNT(*) FROM driver ",nativeQuery = true)
    int countDriver();

    @Query(value = "SELECT driverID FROM driver ORDER BY driverID DESC LIMIT 1",nativeQuery = true)
    String generatedDriverId();
}
