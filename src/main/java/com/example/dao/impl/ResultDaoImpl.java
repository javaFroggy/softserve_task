package com.example.dao.impl;

import com.example.dao.ResultDao;
import com.example.model.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResultDaoImpl implements ResultDao {
    private final Logger log = LoggerFactory.getLogger(ResultDaoImpl.class);
    private final SessionFactory sessionFactory;


    @Autowired
    public ResultDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Result> findAllResults() {
        Session session = sessionFactory.getCurrentSession();

        List<Result> resultList = session
                .createQuery("FROM Result r")
                .getResultList();
        log.info("found list of all results");
        return resultList;
    }

    @Override
    public List<Result> findAllResultsByUserId(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        List<Result> resultList = session
                .createQuery("FROM Result r WHERE r.user.id = :id")
                .setParameter("id", id)
                .getResultList();
        log.info("found list of results by user id");
        return resultList;
    }

    @Override
    public Result findResultByUserAndTestId(Integer userId, Integer testId) {
        Session session = sessionFactory.getCurrentSession();

        Result result = (Result)session
                .createQuery("FROM Result r WHERE r.user.id = :userId AND r.test.id = :testId")
                .setParameter("userId", userId)
                .setParameter("testId", testId)
                .getSingleResult();
        log.info("found result with id: " + result.getId());
        return result;
    }

    @Override
    public void save(Result result) {
        Session session = sessionFactory.getCurrentSession();
        session.save(result);
        log.info("saved result with id: " + result.getId());
    }

    @Override
    public void update(Result result) {
        Session session = sessionFactory.getCurrentSession();
        session.update(result);
        log.info("updated result with id: " + result.getId());
    }

    @Override
    public void delete(Result result) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(result);
        log.info("deleted result with id: " + result.getId());
    }
}
