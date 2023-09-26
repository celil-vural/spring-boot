package com.springdatajpapostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "surname", "email", "address"})
public class User {
    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "surname",length = 50)
    private String surname;
    @Column(name = "email",length = 50)
    private String email;
    @OneToMany
    @JoinColumn(name = "user_address_id")
    private List<Address> address;
}
