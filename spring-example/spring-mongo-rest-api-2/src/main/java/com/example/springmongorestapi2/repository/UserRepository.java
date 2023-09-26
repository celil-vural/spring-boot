package com.example.springmongorestapi2.repository;

import com.example.springmongorestapi2.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
}
