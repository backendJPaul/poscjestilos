package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.User;
import com.jpaul.poscjestilos.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findById(int _id) {
        Optional<User> userOptional = iUserRepository.findById(_id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not found by id" + _id);
        }
    }

    @Override
    public User save(User _user) {
        return iUserRepository.save(_user);
    }

    @Override
    public User update(User _user) {
        Optional<User> userOptional = iUserRepository.findById(_user.getId());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(_user.getName());
            return iUserRepository.save(user);
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + _user.getId());
        }
    }

    @Override
    public void delete(int _id) {
        Optional<User> userOptional = iUserRepository.findById(_id);
        if(userOptional.isPresent()){
            iUserRepository.delete(userOptional.get());
        }
        else{
            throw new ResourceNotFoundException("Resource not found exception by Id" + _id);
        }
    }
}
