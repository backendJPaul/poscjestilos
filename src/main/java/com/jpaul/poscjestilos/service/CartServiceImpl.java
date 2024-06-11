package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Cart;
import com.jpaul.poscjestilos.model.Product;
import com.jpaul.poscjestilos.repository.ICartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements ICartService{

    private ICartRepository iCartRepository;

    @Override
    public List<Cart> findAll() {
        return iCartRepository.findAll();
    }

    @Override
    public Cart findById(int _id) {
        Optional<Cart> cartOptional = iCartRepository.findById(_id);
        if(cartOptional.isPresent()){
            return cartOptional.get();
        }
        else{
            throw new ResourceNotFoundException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID + _id);
        }
    }

    @Override
    public Cart save(Cart _cart) {
        return iCartRepository.save(_cart);
    }

    @Override
    public Cart update(Cart _cart) {
        Optional<Cart> cartOptional = iCartRepository.findById(_cart.getId());
        if(cartOptional.isPresent()){
            Cart cart = cartOptional.get();
            cart.setDiscount(_cart.getDiscount());
            cart.setTotal(_cart.getTotal());
            cart.setUser(_cart.getUser());

            return iCartRepository.save(cart);
        }
        else{
            throw new ResourceNotFoundException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID + _cart.getId());
        }
    }

    @Override
    public void delete(int _id) {
        Optional<Cart> cartOptional = iCartRepository.findById(_id);
        if(cartOptional.isPresent()){
            iCartRepository.delete(cartOptional.get());
        }
        else{
            throw new ResourceNotFoundException(ResourceNotFoundException.RESOURCE_NOT_FOUND_BY_ID + _id);
        }


    }
}
