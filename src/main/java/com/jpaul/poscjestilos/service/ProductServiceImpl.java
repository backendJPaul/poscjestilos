package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Product;
import com.jpaul.poscjestilos.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService{

    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Integer _id) {
        Optional<Product> productOptional = iProductRepository.findById(_id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + _id);
        }
    }

    @Override
    public Product save(Product _product) {
        return iProductRepository.save(_product);
    }

    @Override
    public Product update(Product _product) {
        Optional<Product> productOptional = iProductRepository.findById(_product.getId());
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(_product.getName());
            product.setColor(_product.getColor());
            product.setSize(_product.getSize());
            product.setSalePrice(_product.getSalePrice());
            product.setBuyPrice(_product.getBuyPrice());
            product.setGenre(_product.getGenre());
            product.setBrand(_product.getBrand());
            product.setCategory(_product.getCategory());

            return iProductRepository.save(product);
        }
        else {
            throw new ResourceNotFoundException("Resource not found by Id" + _product.getId());
        }
    }

    @Override
    public void delete(Integer id) {
        Optional<Product> productOptional = iProductRepository.findById(id);
        if(productOptional.isPresent()){
            iProductRepository.delete(productOptional.get());
        }
    }
}
