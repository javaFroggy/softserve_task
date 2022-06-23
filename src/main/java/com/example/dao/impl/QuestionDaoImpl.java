package com.example.dao.impl;

import com.example.dao.QuestionDao;
import com.example.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionDaoImpl implements QuestionDao {

    private Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
    private final SessionFactory sessionFactory;


    @Autowired
    public QuestionDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Question findQuestionById(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        Question question = (Question)session.createQuery("FROM Question q WHERE q.id = :id")
                .setParameter("id", id).getSingleResult();

        return question;
    }

    @Override
    public List<Question> findQuestionsByTestId(Integer testId) {
        Session session = sessionFactory.getCurrentSession();

        List<Question> list = session.createQuery("FROM Question q WHERE q.test.id = :id")
                .setParameter("id", testId).getResultList();

        return list;
    }
}
