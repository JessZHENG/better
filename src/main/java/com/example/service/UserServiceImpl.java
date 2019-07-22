package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User saveOrUpdateUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User registerUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public Page<User> listUsersByNameLike(String userName,Pageable pageable){
        //模糊查询
        userName="%" +userName+"%";
        Page<User> users=userRepository.findByNameLike(userName,pageable);
        return users;
    }
}
