package com.example.demomvc.services;

import com.example.demomvc.model.User;
import com.example.demomvc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServicesImpl implements UserDetailsService {

    final static Logger LOGGER = LoggerFactory.getLogger(UserDetailServicesImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        LOGGER.debug("Find User by Name: {}", userName);
        User user = userRepository.findById(userName).get();
        if (user == null) {
            LOGGER.debug("{} not found!", userName);
            throw new UsernameNotFoundException("Tài khoản :" + userName + " không tồn tại !");
        }
        List<String> roles = user.getRoles();
        List<GrantedAuthority> grantList = new ArrayList<>();
        roles.forEach(item -> {
            grantList.add(new SimpleGrantedAuthority(item));
        });
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), grantList);
        return userDetails;
    }
}
