package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.User;
import com.NetCracked.project.gromov.thundersound.repository.UserRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById (int Id) {
        return userRepository.findById(Id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        User userToBD = userRepository.findById(id).get();
        userToBD.setNickname(user.getNickname());
        userToBD.setPassword(user.getPassword());
        userToBD.setLogin(user.getLogin());
        userRepository.save(userToBD);
    }
}