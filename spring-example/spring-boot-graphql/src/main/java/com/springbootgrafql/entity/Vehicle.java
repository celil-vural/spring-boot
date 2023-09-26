package com.springbootgrafql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long id;
    @Column(name = "type",length = 100)
    private String type;
    @Column(name = "model_code",length = 100)
    private String modelCode;
    @Column(name = "brand_name",length = 100)
    private String brandName;
    @Column(name = "launch_date",length = 100)
    private Date launchDate;
}
