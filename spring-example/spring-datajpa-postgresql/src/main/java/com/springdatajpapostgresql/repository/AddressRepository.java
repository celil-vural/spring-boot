package com.springdatajpapostgresql.repository;

import com.springdatajpapostgresql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{
}
