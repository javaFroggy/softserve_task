package com.example.dao;

import com.example.model.User;

import java.util.List;

public interface UserDao {

    User findById(Integer id);

    User findByUserName(String userName);

    List<User> getAllUsers();

    void save(User user);
}
