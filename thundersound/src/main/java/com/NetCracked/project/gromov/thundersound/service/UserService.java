package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.User;
import com.NetCracked.project.gromov.thundersound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public List<User> findAllByNickname(String nickname){
        return userRepository.findAllByNickname(nickname);
    }

    public List<User> findAllById (UUID Id) {
        return userRepository.findAllById(Id);
    }
}