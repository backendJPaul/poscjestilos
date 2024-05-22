package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Sale;
import com.jpaul.poscjestilos.repository.IInventoryRepository;
import com.jpaul.poscjestilos.repository.ISaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SaleServiceImpl implements ISaleService {

    ISaleRepository iSaleRepository;

    @Override
    public List<Sale> findAll() {
        return iSaleRepository.findAll();
    }

    @Override
    public Sale findById(Integer _id) {
        Optional<Sale> saleOptional = iSaleRepository.findById(_id);
        if(saleOptional.isPresent()){
            return saleOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + _id);
        }
    }

    @Override
    public Sale save(Sale sale) {
        return iSaleRepository.save(sale);
    }

    @Override
    public Sale update(Sale _sale) {
        Optional<Sale> saleOptional = iSaleRepository.findById(_sale.getId());
        if(saleOptional.isPresent()){
            Sale sale = saleOptional.get();
            sale.setIdentifier(_sale.getIdentifier());
            sale.setDiscount(_sale.getDiscount());
            sale.setQuantity(_sale.getQuantity());

            sale.setUser(_sale.getUser());
            sale.setProduct(_sale.getProduct());

            return iSaleRepository.save(sale);
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + _sale.getId());
        }
    }

    @Override
    public void delete(Integer _id) {
        Optional<Sale> saleOptional = iSaleRepository.findById(_id);
        if(saleOptional.isPresent()){
            iSaleRepository.delete(saleOptional.get());

        }
    }
}
