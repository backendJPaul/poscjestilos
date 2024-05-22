package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Inventory;
import com.jpaul.poscjestilos.repository.IInventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements IInventoryService{

    private IInventoryRepository iInventoryRepository;

    @Override
    public List<Inventory> findAll() {
        return iInventoryRepository.findAll();
    }

    @Override
    public Inventory findById(Integer _id) {
        Optional<Inventory> inventoryOptional = iInventoryRepository.findById(_id);
        if(inventoryOptional.isPresent()){
            return inventoryOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + _id);
        }
    }

    @Override
    public Inventory save(Inventory inventory) {
        return iInventoryRepository.save(inventory);
    }

    @Override
    public Inventory update(Inventory _inventory) {
        Optional<Inventory> inventoryOptional = iInventoryRepository.findById(_inventory.getId());
        if(inventoryOptional.isPresent()){
            Inventory inventory = inventoryOptional.get();
            inventory.setBeginningAvailableQuantity(_inventory.getBeginningAvailableQuantity());
            inventory.setProduct(_inventory.getProduct());

            return iInventoryRepository.save(inventory);
        }
        else{
            throw new ResourceNotFoundException("Resource not found by id " + _inventory.getId());
        }
    }

    @Override
    public void delete(Integer _id) {
        Optional<Inventory> inventory = iInventoryRepository.findById(_id);
        if(inventory.isPresent()){
            iInventoryRepository.delete(inventory.get());
        }
    }
}
