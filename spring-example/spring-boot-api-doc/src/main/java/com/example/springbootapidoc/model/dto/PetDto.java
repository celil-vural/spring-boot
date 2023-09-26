package com.example.springbootapidoc.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PetDto", description = "PetDto")
public class PetDto {
    @ApiModelProperty(value = "PetDto id", example = "1")
    private int id;
    @ApiModelProperty(value = "PetDto name", example = "dog")
    private String name;
    @ApiModelProperty(value = "PetDto date", example = "2020-01-01")
    private Date date;
}
