package com.NetCracked.project.gromov.thundersound.repository;

import com.NetCracked.project.gromov.thundersound.entity.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByNickname(String nickname);
    Boolean existsByNickname(String nickname);
    Boolean existsByLogin(String login);
}
