package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Brand;
import com.jpaul.poscjestilos.repository.IBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements IBrandService {

    private IBrandRepository iBrandRepository;

    @Override
    public List<Brand> findAll() {
        return iBrandRepository.findAll();
    }

    @Override
    public Brand findById(int _id) {
        Optional<Brand> brandOptional = iBrandRepository.findById(_id);
        if(brandOptional.isPresent()){
            return brandOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not found exception " + _id);
        }
    }

    @Override
    public Brand save(Brand _brand) {
        return iBrandRepository.save(_brand);
    }

    @Override
    public Brand update(Brand _brand) {
        Optional<Brand> brandOptional = iBrandRepository.findById(_brand.getId());
        if(brandOptional.isPresent()){
            Brand brand = brandOptional.get();
            brand.setName(brand.getName());

            return iBrandRepository.save(brand);
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + _brand.getId());
        }
    }

    @Override
    public void delete(int _id) {
        Optional<Brand> brandOptional = iBrandRepository.findById(_id);
        if(brandOptional.isPresent()){
            iBrandRepository.delete(brandOptional.get());
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + _id);
        }
    }
}
