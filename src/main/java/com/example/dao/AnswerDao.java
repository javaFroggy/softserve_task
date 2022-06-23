package com.example.dao;

import com.example.model.Answer;

import java.util.List;

public interface AnswerDao {

    /**
     * @param questionId - id of question to find answers
     * @return answers to question
     */
    List<Answer> getAllAnswersByQuestionId(Integer questionId);

}
