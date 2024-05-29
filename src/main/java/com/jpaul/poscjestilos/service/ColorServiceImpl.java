package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Color;
import com.jpaul.poscjestilos.repository.IColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ColorServiceImpl implements IColorService{

    private IColorRepository iColorRepository;

    @Override
    public List<Color> findAll() {
        return iColorRepository.findAll();
    }

    @Override
    public Color findById(int id) {
        Optional<Color> colorOptional = iColorRepository.findById(id);
        if(colorOptional.isPresent()){
            return colorOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + id);
        }
    }

    @Override
    public Color save(Color _color) {
        return iColorRepository.save(_color);
    }

    @Override
    public Color update(Color _color) {
        Optional<Color> colorOptional = iColorRepository.findById(_color.getId());
        if(colorOptional.isPresent()){
            Color color = colorOptional.get();
            color.setName(_color.getName());

            return iColorRepository.save(color);
        }
        else{
            throw new ResourceNotFoundException("Resource not found exception " + _color.getId());
        }
    }

    @Override
    public void delete(int id) {
        Optional<Color> colorOptional = iColorRepository.findById(id);
        if(colorOptional.isPresent()){
            iColorRepository.delete(colorOptional.get());
        }
        else{
            throw new ResourceNotFoundException("Resource not found exception" + id);
        }
    }
}
