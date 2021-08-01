package com.example.jwt.demo.service.impl;

import com.example.jwt.demo.entity.User;
import com.example.jwt.demo.payload.UserInfo;
import com.example.jwt.demo.repository.RoleRepository;
import com.example.jwt.demo.repository.UserRepository;
import com.example.jwt.demo.service.UserService;
import com.example.jwt.demo.service.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<UserInfo> getAllUsers() {
        List<UserInfo> userInfos = null;
        List<User> users = userRepository.findAll();
        if(users!=null){
            userInfos = new ArrayList<>();
            for (User user: users){
                userInfos.add(new UserMapper().toUserInfo(user));
            }
        }
        return userInfos;
    }

    @Override
    public UserInfo getUserById(Long id) {
        final Optional<User> byId = userRepository.findById(id);
        if(byId.get()!=null)
            return new UserMapper().toUserInfo(byId.get());
        return null;
    }

    @Override
    public UserInfo getUserByUserName(String userName) {
        final Optional<User> byId = userRepository.findByUsername(userName);
        if(byId.get()!=null)
            return new UserMapper().toUserInfo(byId.get());
        return null;
    }

    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        User user = null;
        if(userInfo.getUsername()!=null || !userInfo.getUsername().trim().isEmpty())
            user = userRepository.findByUsername(userInfo.getUsername()).get();
        else if(userInfo.getEmail()!=null || !userInfo.getEmail().trim().isEmpty())
            user = userRepository.findByEmail(userInfo.getUsername()).get();

        if(user.getId()==null){
            log.debug("updateUser: user no exist");
        }

        userRepository.save(new UserMapper().toUser(user.getId(), userInfo, roleRepository.findAll()));
        return null;
    }

    @Override
    public boolean deleteUserInfo(UserInfo userInfo) {
        return false;
    }
}
