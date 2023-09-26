package com.springdatajpapostgresql.service.concrete;

import com.springdatajpapostgresql.dto.AddressDto;
import com.springdatajpapostgresql.dto.UserDto;
import com.springdatajpapostgresql.entity.Address;
import com.springdatajpapostgresql.entity.User;
import com.springdatajpapostgresql.repository.AddressRepository;
import com.springdatajpapostgresql.repository.UserRepository;
import com.springdatajpapostgresql.service.contract.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        Assert.notNull(userDto.getName(),"Name must not be null");
        Assert.notNull(userDto.getSurname(),"Surname must not be null");
        Assert.isNull(userDto.getEmail(),"Email must not be null");
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        final User userDb=userRepository.save(user);
        List<Address> addresses = new ArrayList<>();
        List<AddressDto> addressDtos=userDto.getAddresses();
        for (AddressDto addressDto:addressDtos) {
            Address address = new Address();
            address.setAddress(addressDto.getAddress());
            address.setAddressType(addressDto.getAddressType());
            address.setActive(addressDto.getActive());
            address.setUser(userDb);
            addresses.add(address);
        }
        addressRepository.saveAll(addresses);
        user.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDto update(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users=userRepository.findAll();
        List<UserDto> userDtos=new ArrayList<>();
        for(User user:users){
            UserDto userDto=new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setEmail(user.getEmail());
            List<Address> addresses=user.getAddress();
            List<AddressDto> addressDtos=new ArrayList<>();
            for(Address address:addresses){
                AddressDto addressDto=new AddressDto();
                addressDto.setId(address.getId());
                addressDto.setAddress(address.getAddress());
                addressDto.setAddressType(address.getAddressType());
                addressDto.setActive(address.getActive());
                addressDtos.add(addressDto);
            }
            userDto.setAddresses(addressDtos);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return null;
    }
}
