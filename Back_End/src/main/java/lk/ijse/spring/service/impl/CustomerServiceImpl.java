package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getNicNo())) {
            throw new RuntimeException("Customer already exists");
        }

        Customer map = mapper.map(customerDTO, Customer.class);
        customerRepo.save(map);
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException("Customer Not exists.Please enter valid Id");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getNicNo())) {
            throw new RuntimeException("Customer Not exists.Please enter valid Id");
        }

        Customer map = mapper.map(customerDTO, Customer.class);
        customerRepo.save(map);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        ArrayList<CustomerDTO> allList=mapper.map(customerRepo.findAll(),new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
        return allList;
    }

    @Override
    public CustomerDTO searchCustomerWithNic(String id) {
        return mapper.map(customerRepo.findById(id), CustomerDTO.class);
    }

    @Override
    public CustomerDTO searchCustomerWithName(String name) {
        return mapper.map(customerRepo.findCustomerByName(name), CustomerDTO.class);
    }
}
