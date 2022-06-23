package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.createQuery("FROM User u WHERE u.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        log.info("found user by id " + id);
        return user;
    }

    @Override
    public User findByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.createQuery("FROM User u WHERE u.username = :username")
                .setParameter("username", userName)
                .getSingleResult();
        log.info("found user by username: " + userName + ", with id: " + user.getId());
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("From User u").getResultList();
        log.info("found list of users");
        return null;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        log.info("saving user with username: " + user.getUsername() + ", id: " + user.getId());
        session.save(user);
    }
}
