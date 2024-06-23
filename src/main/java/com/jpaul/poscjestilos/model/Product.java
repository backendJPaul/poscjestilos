package com.jpaul.poscjestilos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "product")
public class Product {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //TODO make name unique

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String genre;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
