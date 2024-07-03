package com.jpaul.poscjestilos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="material")
public class Material {
    private static final long versionSerial=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;
}
