package com.company.car.casano.mapper;

import com.company.car.casano.dto.UserDTO;
import com.company.car.casano.dto.request.CreateUserRequest;
import com.company.car.casano.entity.User;

import java.util.List;

public interface UserMapper {
    UserDTO toDTO(User entity);
    List<UserDTO> toDTOList(List<User> entities);
    User toEntity(CreateUserRequest request);
}
