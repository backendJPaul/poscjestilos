package com.jpaul.poscjestilos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "inventory")
public class Inventory {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int beginningAvailableQuantity;

    @Column(nullable = false)
    LocalTime dateUpdate = LocalTime.now();

    @ManyToOne
    @JoinColumn(name = "item_product_id")
    private ItemProduct itemProduct;



}
