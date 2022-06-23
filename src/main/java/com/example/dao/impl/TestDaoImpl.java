package com.example.dao.impl;

import com.example.dao.TestDao;
import com.example.model.Question;
import com.example.model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaoImpl implements TestDao {

    private final Logger log = LoggerFactory.getLogger(TestDaoImpl.class);
    private final SessionFactory sessionFactory;


    @Autowired
    public TestDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Test findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        Test test = (Test) session
                .createQuery("FROM Test t WHERE t.id = :id")
                .setParameter("id", id)
                .getSingleResult();

        log.info("found test with id: " + id);

        return test;
    }

    @Override
    public List<Test> getAllTests() {
        Session session = sessionFactory.getCurrentSession();

        List<Test> result = session
                .createQuery("FROM Test t")
                .getResultList();

        log.info("found all tests");

        return result;
    }

    @Override
    public void save(Test test) {
        Session session = sessionFactory.getCurrentSession();

        session.save(test);

        log.info("saved test with id: " + test.getId());
    }

    @Override
    public List<Question> getQuestionsByTest(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        List<Question> result = session
                .createQuery("FROM Question q WHERE test.id = :id")
                .setParameter("id", id)
                .getResultList();

        log.info("found questions of test with id: " + id);
        return result;
    }

    @Override
    public void update(Test test) {
        Session session = sessionFactory.getCurrentSession();
        session.update(test);
        log.info("updated test with name: " + test.getTestName() + ", id: " + test.getId());
    }

    @Override
    public void delete(Test test) {
        Session session = sessionFactory.getCurrentSession();
        session.update(test);
        log.info("deleted test with name: " + test.getTestName() + ", id: " + test.getId());
    }
}
