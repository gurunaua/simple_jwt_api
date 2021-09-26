package com.example.jwt.demo.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "segment")
@Entity
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_table", nullable = false)
    private Desk idTable;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "descrition", length = 150)
    private String descrition;

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

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Desk getIdTable() {
        return idTable;
    }

    public void setIdTable(Desk idTable) {
        this.idTable = idTable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}