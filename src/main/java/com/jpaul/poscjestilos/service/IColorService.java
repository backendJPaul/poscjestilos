package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.Color;

import java.util.List;

public interface IColorService {
    public List<Color> findAll();
    public Color findById(int id);
    public Color save(Color _color);
    public Color update(Color _color);
    public void delete(int id);
}
