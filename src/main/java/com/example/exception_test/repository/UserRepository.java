package com.example.exception_test.repository;

import com.example.exception_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUserId(int id);
    User findUserByUserName(String userName);
    User findUserByEmail(String email);

}
