package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo  extends JpaRepository<Customer,String> {
    Customer findCustomerByName(String name);
    @Query(value = "SELECT COUNT(*) FROM customer",nativeQuery = true)
    int countCustomer();
}
