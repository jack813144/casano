package com.company.car.casano.service;

import com.company.car.casano.dto.UserDTO;
import com.company.car.casano.dto.request.CreateUserRequest;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(CreateUserRequest createUserRequest);
    Boolean deleteUser(Long id);
}
