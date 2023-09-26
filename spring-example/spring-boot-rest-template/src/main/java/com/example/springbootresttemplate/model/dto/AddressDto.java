package com.example.springbootresttemplate.model.dto;

import com.example.springbootresttemplate.model.AddressType;
import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String address;
    private AddressType addressType;
    private Boolean active;
    private UserDto userDto;
}
