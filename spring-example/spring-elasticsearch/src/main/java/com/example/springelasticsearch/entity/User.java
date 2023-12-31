package com.example.springelasticsearch.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
@Document(indexName = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    @Field(name = "name",type = FieldType.Text)
    private String name;

    @Field(name = "surname",type = FieldType.Text)
    private String surname;

    @Field(name = "address",type = FieldType.Text)
    private String address;

    @Field(name = "birthDate",type = FieldType.Date)
    private Date birthDate;
}
