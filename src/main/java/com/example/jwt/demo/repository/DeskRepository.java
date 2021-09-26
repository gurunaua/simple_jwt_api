package com.example.jwt.demo.repository;

import com.example.jwt.demo.entity.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk, Integer> {
}