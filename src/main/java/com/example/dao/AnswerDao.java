package com.example.dao;

import com.example.model.Answer;

import java.util.List;

public interface AnswerDao {

    List<Answer> getAllAnswersByQuestionId(Integer testId);


}
