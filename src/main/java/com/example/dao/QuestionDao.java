package com.example.dao;

import com.example.model.Question;

import java.util.List;

public interface QuestionDao {

    /**
     * @param id question id to find
     * @return Question object
     */
    Question findQuestionById(Integer id);

    /**
     * @param testId - id of test to find questions
     * @return list of questions of a test
     */
    List<Question> findQuestionsByTestId(Integer testId);


}
