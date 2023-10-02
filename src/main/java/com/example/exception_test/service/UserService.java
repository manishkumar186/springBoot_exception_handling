package com.example.exception_test.service;

import com.example.exception_test.entity.User;
import com.example.exception_test.exception.EmailAlreadyExists;
import com.example.exception_test.exception.UserNameAlreadyExists;
import com.example.exception_test.exception.UserNotFoundException;

import com.example.exception_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User saveUser(User user) throws UserNameAlreadyExists, EmailAlreadyExists {
        User userData = userRepository.findUserByUserName(user.getUserName());
        User checkEmail = userRepository.findUserByEmail(user.getEmail());
        if(userData!=null){
            throw new UserNameAlreadyExists("This username already register = "+user.getUserName());
        }
        else if (checkEmail!=null){
            throw new EmailAlreadyExists("This email already register = "+user.getEmail());
        }
        else{
            return userRepository.save(user);
        }

    }

    public List<User> getALlUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findUserByUserId(id);
        if(user!= null){
           return user;
        }
        else{
            throw new UserNotFoundException("user not found with id = "+id);
        }
    }


}
