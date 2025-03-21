package com.example.moviestutorial.repository;

import com.example.moviestutorial.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByLogin(String login);
}
