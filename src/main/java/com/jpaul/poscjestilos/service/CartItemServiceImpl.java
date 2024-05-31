package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.CartItem;
import com.jpaul.poscjestilos.repository.ICartItemRepository;

import java.util.List;
import java.util.Optional;

public class CartItemServiceImpl implements ICartItemService{

    private ICartItemRepository iCartItemRepository;

    @Override
    public List<CartItem> findAll() {
        return iCartItemRepository.findAll();
    }

    @Override
    public CartItem findById(int _id) {
        Optional<CartItem> cartItemOptional = iCartItemRepository.findById(_id);
        if(cartItemOptional.isPresent()){
            return cartItemOptional.get();
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + _id);
        }
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return iCartItemRepository.save(cartItem);
    }

    @Override
    public CartItem update(CartItem _cartItem) {
        Optional<CartItem> cartItemOptional = iCartItemRepository.findById(_cartItem.getId());
        if(cartItemOptional.isPresent()){
            CartItem cartItem = cartItemOptional.get();
            cartItem.setDiscount(_cartItem.getDiscount());
            cartItem.setQuantity(_cartItem.getQuantity());
            cartItem.setProduct(_cartItem.getProduct());
            iCartItemRepository.save(cartItem);
            return cartItem;
        }
        else {
            throw new ResourceNotFoundException("Resource not found by id" + _cartItem.getId());
        }

    }

    @Override
    public void delete(int _id) {
        Optional<CartItem> cartItemOptional = iCartItemRepository.findById(_id);
        if(cartItemOptional.isPresent()){
            iCartItemRepository.delete(cartItemOptional.get());
        }
    }
}
