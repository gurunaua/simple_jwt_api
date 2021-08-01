package com.example.jwt.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    public static String ROLE_USER = "USER";
    public static String ROLE_PM = "PM";
    public static String ROLE_TEST = "TEST";
    public static String ROLE_ADMIN = "ADMIN";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

    public Role() {
    }


}