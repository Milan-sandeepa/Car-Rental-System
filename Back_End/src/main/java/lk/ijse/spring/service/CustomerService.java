package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.UserDTO;

import java.util.ArrayList;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO);

    public void deleteCustomer(String id);

    public void updateCustomer(CustomerDTO customerDTO);

    public ArrayList<CustomerDTO> getAllCustomer();

    public CustomerDTO searchCustomerWithNic(String id);

    public CustomerDTO searchCustomerWithName(String name);

    public int countCustomer();
}
