package com.jpaul.poscjestilos.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name ="item_product")
public class ItemProduct {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private BigDecimal salePrice;

    @Column(nullable = false)
    private BigDecimal buyPrice;

    @Column(nullable = false)
    @ManyToOne
    private Product product;
}
