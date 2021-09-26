package com.example.jwt.demo.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private Integer name;

    @Column(name = "phone", length = 20)
    private String phone;

    @Lob
    @Column(name = "descrition")
    private String descrition;

    @Column(name = "total")
    private Integer total;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "last_date", nullable = false)
    private Instant lastDate;

    public Instant getLastDate() {
        return lastDate;
    }

    public void setLastDate(Instant lastDate) {
        this.lastDate = lastDate;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}