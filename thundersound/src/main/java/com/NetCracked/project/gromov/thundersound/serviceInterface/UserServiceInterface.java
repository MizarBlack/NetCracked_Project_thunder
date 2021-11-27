package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInterface {

    ResponseEntity<User> saveUser(User user);

    ResponseEntity<List<User>> findAll();

    ResponseEntity<User> findById (int Id);

    ResponseEntity<HttpStatus> deleteById(int id);

    ResponseEntity<User> updateUser(int id, User user);

}
