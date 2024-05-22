package com.jpaul.poscjestilos.model;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "sale")
public class Sale {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int identifier;

    @Column(nullable = false)
    LocalTime dateUpdate = LocalTime.now();

    @Column(nullable = false)
    private BigDecimal discount;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
