package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.User;

import java.util.List;

public interface UserServiceInterface {

    void saveUser(User user);

    List<User> findAll();

    User findById (int Id);

    void deleteById(int id);

    void updateUser(int id, User user);

}
