package com.springdatajpapostgresql.dto;

import com.springdatajpapostgresql.enums.AddressType;
import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String address;
    private AddressType addressType;
    private Boolean active;
    private UserDto userDto;
}
