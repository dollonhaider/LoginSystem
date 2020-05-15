package com.example.loginSystem.repository;

import com.example.loginSystem.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<User, String> {
     User findByEmail(String email);
     User findByPassword(String password);


}
