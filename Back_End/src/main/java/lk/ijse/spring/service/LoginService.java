package lk.ijse.spring.service;

import lk.ijse.spring.dto.UserDTO;

public interface LoginService {
    public UserDTO searchUserWithName(String name);
}
