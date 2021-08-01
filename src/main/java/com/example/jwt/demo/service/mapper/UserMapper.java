package com.example.jwt.demo.service.mapper;

import com.example.jwt.demo.entity.Role;
import com.example.jwt.demo.entity.RoleName;
import com.example.jwt.demo.entity.User;
import com.example.jwt.demo.payload.UserInfo;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;

public class UserMapper {


    PasswordEncoder encoder;

    public UserMapper() {
        this.encoder = encoder;
    }

    public UserMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public UserInfo toUserInfo(User user){
        List<String> roles = user.getRoles()==null?
                null:
                user.getRoles().stream().map(x->x.getName().toString()).collect(Collectors.toList());

        return new UserInfo(user.getName(), user.getUsername(), user.getEmail(), roles,
                user.getPassword(), user.getAddress(), user.getPhoto());
    }


    public User toUser(Long id, UserInfo userInfo, List<Role> existRoles){
        User user = new User();
        if(id!=null)
            user.setId(id);
        user.setName(userInfo.getName());
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setPassword(encoder.encode(userInfo.getPassword()));
        user.setAddress(userInfo.getAddress());
        user.setPhoto(userInfo.getPhoto());
        List<Role> roles= null;
        if(userInfo.getRole()!=null && !user.getRoles().isEmpty()){
            roles = new ArrayList<>();
            for (String role : userInfo.getRole()){
                if(role.trim().toLowerCase().equals(Role.ROLE_ADMIN.toLowerCase()))
                    roles.add(findRole(existRoles, RoleName.ROLE_ADMIN));
                else if(role.trim().toLowerCase().equals(Role.ROLE_TEST.toLowerCase()))
                    roles.add(findRole(existRoles, RoleName.ROLE_TEST));
                else if(role.trim().toLowerCase().equals(Role.ROLE_PM.toLowerCase()))
                    roles.add(findRole(existRoles, RoleName.ROLE_PM));
                else
                    roles.add(findRole(existRoles, RoleName.ROLE_USER));
            }

        }
        user.setRoles(roles);
        return user;
    }

    Role findRole(List<Role> existRoles, RoleName roleName){
        return existRoles.stream().filter(x->x.getName()==roleName).collect(Collectors.toList()).get(0);
    }

}
