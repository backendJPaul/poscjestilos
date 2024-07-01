package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.ItemCart;
import com.jpaul.poscjestilos.repository.IItemCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemCartServiceImpl implements IItemCartService {

    private IItemCartRepository iItemCartRepository;

    @Override
    public List<ItemCart> findAll() {
        return iItemCartRepository.findAll();
    }

    @Override
    public ItemCart findById(int _id) {
        Optional<ItemCart> cartItemOptional = iItemCartRepository.findById(_id);
        if(cartItemOptional.isPresent()){
            return cartItemOptional.get();
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + _id);
        }
    }

    @Override
    public ItemCart save(ItemCart _itemCart) {

        ItemCart itemCart = iItemCartRepository.save(_itemCart);
        return iItemCartRepository.save(itemCart);
    }

    @Override
    public ItemCart update(ItemCart _itemCart) {
        Optional<ItemCart> cartItemOptional = iItemCartRepository.findById(_itemCart.getId());

        if(cartItemOptional.isPresent()){
            ItemCart itemCart = cartItemOptional.get();
            itemCart.setDiscount(_itemCart.getDiscount());
            itemCart.setQuantity(_itemCart.getQuantity());
            itemCart.setCart(_itemCart.getCart());
            itemCart.setItemProduct(_itemCart.getItemProduct());

            iItemCartRepository.save(itemCart);
            return itemCart;
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + _itemCart.getId());
        }

    }

    @Override
    public void delete(int _id) {
        Optional<ItemCart> iItemCartOptional = iItemCartRepository.findById(_id);
        if(iItemCartOptional.isPresent()){
            iItemCartRepository.delete(iItemCartOptional.get());
        }
    }
}
