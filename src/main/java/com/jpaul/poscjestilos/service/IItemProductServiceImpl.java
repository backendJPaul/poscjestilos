package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Inventory;
import com.jpaul.poscjestilos.model.ItemProduct;
import com.jpaul.poscjestilos.repository.IInventoryRepository;
import com.jpaul.poscjestilos.repository.IItemProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IItemProductServiceImpl implements IItemProductService {

    private IItemProductRepository iItemProductRepository;
    private IInventoryService iInventoryService;
    @Override
    public List<ItemProduct> findAll() {
        return iItemProductRepository.findAll();
    }

    @Override
    public ItemProduct findById(Integer _id) {
        Optional<ItemProduct> itemProductOptional = iItemProductRepository.findById(_id);
        if(itemProductOptional.isPresent()){
            return itemProductOptional.get();
        }
        else{
            throw new ResourceNotFoundException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID);
        }
    }

    @Override
    public ItemProduct save(ItemProduct _itemProduct) {
        ItemProduct itemProduct = iItemProductRepository.save(_itemProduct);

        Inventory inventory = new Inventory();
        inventory.setItemProduct(itemProduct);
        inventory.setBeginningAvailableQuantity(0);

        iInventoryService.save(inventory);

        return itemProduct;
    }

    @Override
    public ItemProduct update(ItemProduct _itemProduct) {
        Optional<ItemProduct> itemProductOptional = iItemProductRepository.findById(_itemProduct.getId());
        if(itemProductOptional.isPresent()){
            ItemProduct itemProduct = itemProductOptional.get();
            itemProduct.setName(_itemProduct.getName());
            itemProduct.setSize(_itemProduct.getSize());
            itemProduct.setSalePrice(_itemProduct   .getSalePrice());
            itemProduct.setBuyPrice(_itemProduct.getBuyPrice());
            return iItemProductRepository.save(itemProduct);

        }
        else{
            throw new ResourceNotFoundException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID);
        }
    }

    @Override
    public void delete(Integer _id) {
        Optional<ItemProduct> itemProductOptional = iItemProductRepository.findById(_id);
        if(itemProductOptional.isPresent()){
            iItemProductRepository.delete(itemProductOptional.get());
        }
        else{
            throw new ResourceNotFoundException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID);
        }
    }

    @Override
    public List<ItemProduct> findByProductId(Integer id) {
        List<ItemProduct> itemProducts = iItemProductRepository.findByProductId(id);
        return itemProducts;
    }
}
