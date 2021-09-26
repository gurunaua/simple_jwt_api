package com.example.jwt.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Table(name = "product")
@Entity
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price", precision = 10)
    private BigDecimal price;

    @Column(name = "discount", precision = 10)
    private BigDecimal discount;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}