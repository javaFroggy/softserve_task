package com.example.dao.impl;

import com.example.dao.AnswerDao;
import com.example.model.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnswerDaoImpl implements AnswerDao {


    private Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
    private final SessionFactory sessionFactory;


    @Autowired
    public AnswerDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(Integer questionId) {
        Session session = sessionFactory.getCurrentSession();

        List<Answer> list = session.createQuery("FROM Answer a WHERE a.question.id = :id")
                .setParameter("id", questionId).getResultList();

        return list;
    }
}
