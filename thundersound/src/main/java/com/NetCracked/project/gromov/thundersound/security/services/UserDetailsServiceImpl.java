//package com.NetCracked.project.gromov.thundersound.security.services;
//
//import com.NetCracked.project.gromov.thundersound.entity.User;
//import com.NetCracked.project.gromov.thundersound.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
//        User user = userRepository.findByNickname(nickname)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + nickname));
//
//        return UserDetailsImpl.build(user);
//    }
//
//}
