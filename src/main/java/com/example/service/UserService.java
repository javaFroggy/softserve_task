package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){this.userDao = userDao; }
    public User findById(Integer id){
        return userDao.findById(id);
    }

    public User findByName(String userName){
        return userDao.findByUserName(userName);
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public void saveUser(User user){
        userDao.save(user);
    }

    public boolean userExists(User user){
        return userDao.getAllUsers().stream()
                .anyMatch(u -> u.getId() == user.getId());
    }

}
