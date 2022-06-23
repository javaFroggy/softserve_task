package com.example.dao;

import com.example.model.Answer;
import com.example.model.Question;

import java.util.List;

public interface QuestionDao {

    /**
     * @param id question id to find
     * @return Question object
     */
    Question findQuestionById(Integer id);

    /**
     * @param id - question id to get answers
     * @return List of answers to concrete question
     */
    List<Answer> findAnswersByQuestions(Integer id);

    /**
     * @param question - question to save
     */
    void saveQuestion(Question question);

    /**
     * @param answer - answer to save
     */
    void saveAnswer(Answer answer);

    /**
     * @param question - question to update
     */
    void updateQuestion(Question question);

    /**
     * @param question - question to delete
     */
    void deleteQuestion(Question question);
}
