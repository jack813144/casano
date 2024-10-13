package com.company.car.casano.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String email;
}
