package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

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
        return user;
    }

    @Override
    public User findByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();

        User user = (User) session.createQuery("FROM User u WHERE u.username = :username")
                .setParameter("username", userName)
                .getSingleResult();

        return user;

    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("From User u").getResultList();
        return null;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }
}
