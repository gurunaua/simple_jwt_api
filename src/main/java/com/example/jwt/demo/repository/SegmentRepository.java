package com.example.jwt.demo.repository;

import com.example.jwt.demo.entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentRepository extends JpaRepository<Segment, Integer> {
}