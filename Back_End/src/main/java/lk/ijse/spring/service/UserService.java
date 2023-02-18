package lk.ijse.spring.service;

import lk.ijse.spring.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    public void saveUser(UserDTO userDTO);

    public void deleteUser(String id);

    public void updateUser(UserDTO userDTO);

    public ArrayList<UserDTO> getAllUser();

    public UserDTO searchUserWithName(String name);
}
