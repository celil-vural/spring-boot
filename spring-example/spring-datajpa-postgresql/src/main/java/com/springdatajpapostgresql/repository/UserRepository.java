package com.springdatajpapostgresql.repository;

import com.springdatajpapostgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
