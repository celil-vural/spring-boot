package com.example.springbootresttemplate.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private List<AddressDto> addresses;
}
