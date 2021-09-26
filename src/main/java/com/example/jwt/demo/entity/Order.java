package com.example.jwt.demo.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer idCustomer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_segment", nullable = false)
    private Segment idSegment;

    @Lob
    @Column(name = "descrition")
    private String descrition;

    @Column(name = "discount")
    private Integer discount;

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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public Segment getIdSegment() {
        return idSegment;
    }

    public void setIdSegment(Segment idSegment) {
        this.idSegment = idSegment;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}