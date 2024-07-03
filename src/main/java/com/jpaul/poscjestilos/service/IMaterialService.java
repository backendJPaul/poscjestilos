package com.jpaul.poscjestilos.service;


import com.jpaul.poscjestilos.model.Material;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMaterialService {
    List<Material> findAll();
    Material findById(int _id);
    Material save(Material material);
    Material update(Material material);

    void delete(int _id);
}
