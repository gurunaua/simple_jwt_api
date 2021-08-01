package com.example.jwt.demo.service;

import com.example.jwt.demo.payload.UserInfo;

import java.util.List;

public interface UserService {

    public List<UserInfo> getAllUsers();
    public UserInfo getUserById(Long id);
    public UserInfo getUserByUserName(String userName);
    public UserInfo updateUser(UserInfo userInfo);
    public boolean deleteUserInfo(UserInfo userInfo);

}
