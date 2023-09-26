package com.springbootgrafql.entity.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class VehicleDto {
    private String type;
    private String modelCode;
    private String brandName;
}
