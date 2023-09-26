package com.springdatajpapostgresql.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private List<AddressDto> addresses;

}
