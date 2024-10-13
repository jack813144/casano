package com.company.car.casano.mapper.impl;

import com.company.car.casano.dto.UserDTO;
import com.company.car.casano.dto.request.CreateUserRequest;
import com.company.car.casano.entity.User;
import com.company.car.casano.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO toDTO(User entity) {
        if (entity == null) {
            return null;
        }
        return UserDTO.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public List<UserDTO> toDTOList(List<User> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        List<UserDTO> lst = new ArrayList<>();
        for (User entity : entities) {
            lst.add(toDTO(entity));
        }
        return lst;
    }

    @Override
    public User toEntity(CreateUserRequest request) {
        if (request == null) {
            return null;
        }
        User entity = new User();
        entity.setUserName(request.getUserName());
        entity.setEmail(request.getEmail());
        return entity;
    }
}
