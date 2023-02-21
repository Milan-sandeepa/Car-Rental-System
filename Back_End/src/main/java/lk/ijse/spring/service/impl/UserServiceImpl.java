package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        User map = mapper.map(userDTO, User.class);
        userRepo.save(map);
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }

    @Override
    public ArrayList<UserDTO> getAllUser() {
        ArrayList<UserDTO> allList=mapper.map(userRepo.findAll(),new TypeToken<ArrayList<UserDTO>>(){}.getType());
        return allList;
    }

    @Override
    public UserDTO searchUserWithName(String name) {
        return null;
    }
}
