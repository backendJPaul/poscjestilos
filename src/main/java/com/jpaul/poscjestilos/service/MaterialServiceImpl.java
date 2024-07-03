package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Material;
import com.jpaul.poscjestilos.repository.IMaterialRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MaterialServiceImpl implements IMaterialService{

    private IMaterialRepository iMaterialRepository;

    @Override
    public List<Material> findAll() {
        return iMaterialRepository.findAll();
    }

    @Override
    public Material findById(int _id) {
        Optional<Material> materialOptional = iMaterialRepository.findById(_id);
        if(materialOptional.isPresent()){
            return materialOptional.get();
        }
        else{
            throw new ResourceNotFoundException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID);
        }
    }

    @Override
    public Material save(Material material) {
        return iMaterialRepository.save(material);
    }

    @Override
    public Material update(Material _material) {
        Optional<Material> materialOptional = iMaterialRepository.findById(_material.getId());
        if(materialOptional.isPresent()){
            Material material = materialOptional.get();
            material.setName(_material.getName());
            return iMaterialRepository.save(material);
        }
        else{
            throw new ResourceNotFoundException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID);
        }
    }

    @Override
    public void delete(int _id) {
        Optional<Material> materialOptional = iMaterialRepository.findById(_id);
        if(materialOptional.isPresent()){
            iMaterialRepository.delete(materialOptional.get());
        }
        else{
            throw new ResourceClosedException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID);
        }
    }

}
