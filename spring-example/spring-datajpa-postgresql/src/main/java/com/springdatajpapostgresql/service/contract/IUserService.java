package com.springdatajpapostgresql.service.contract;

import com.springdatajpapostgresql.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService{
    UserDto save(UserDto userDto);
    void delete(Long id);
    UserDto update(UserDto userDto);
    List<UserDto> findAll();
    Page<UserDto> findAll(Pageable pageable);
}
