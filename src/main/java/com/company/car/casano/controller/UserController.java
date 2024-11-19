package com.company.car.casano.controller;


import com.company.car.casano.dto.UserDTO;
import com.company.car.casano.dto.request.CreateUserRequest;
import com.company.car.casano.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUserById(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
