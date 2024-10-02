package com.company.car.casano.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
