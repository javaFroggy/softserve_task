package com.example.dao.impl;

import com.example.dao.TestDao;
import com.example.model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestDaoImpl implements TestDao {

    private final Logger log = LoggerFactory.getLogger(TestDaoImpl.class);
    private final SessionFactory sessionFactory;


    @Autowired
    public TestDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Test findById(Integer testId) {

        Session session = sessionFactory.getCurrentSession();

        Test test = (Test) session
                .createQuery("FROM Test t WHERE t.id = :id")
                .setParameter("id", testId)
                .getSingleResult();

        log.info("found test with id: " + testId);

        return test;
    }

    @Override
    public List<Test> getAllTests() {
        Session session = sessionFactory.getCurrentSession();

        List<Test> list = session
                .createQuery("FROM Test t")
                .getResultList();

        log.info("found all tests");

        return list;
    }

    @Override
    public void save(Test test) {
        Session session = sessionFactory.getCurrentSession();

        session.save(test);

        log.info("saved test with id: " + test.getId());
    }
}
