package com.example.jwt.demo.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
public class UserInfo {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;

    private List<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String address;

    private String photo;

    public UserInfo(String name,
                    String username,
                    String email,
                    List<String> role,
                    String password,
                    String address,
                    String photo) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
        this.address = address;
        this.photo = photo;
    }
}
