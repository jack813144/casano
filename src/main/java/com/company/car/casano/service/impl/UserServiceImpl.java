package com.company.car.casano.service.impl;

import com.company.car.casano.dto.UserDTO;
import com.company.car.casano.dto.request.CreateUserRequest;
import com.company.car.casano.entity.User;
import com.company.car.casano.mapper.UserMapper;
import com.company.car.casano.repository.UserRepository;
import com.company.car.casano.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.getById(id);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO createUser(CreateUserRequest createUserRequest) {
        User user = userMapper.toEntity(createUserRequest);
        if (user == null) {
            return null;
        }
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
