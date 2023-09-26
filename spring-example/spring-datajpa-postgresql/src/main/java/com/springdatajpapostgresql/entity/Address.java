package com.springdatajpapostgresql.entity;

import com.springdatajpapostgresql.enums.AddressType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "address", "addressType", "active"})
public class Address implements Serializable {
    @Id
    @SequenceGenerator(name = "address_id_seq", sequenceName = "address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
    private Long id;
    @Column(name = "address",length = 500)
    private String address;
    @Enumerated
    private AddressType addressType;
    @Column(name = "active")
    private Boolean active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_address_id")
    private User user;

}
