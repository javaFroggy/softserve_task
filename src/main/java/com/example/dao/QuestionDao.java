package com.example.dao;

import com.example.model.Question;

import java.util.List;

public interface QuestionDao {

    Question findQuestionById(Integer id);

    List<Question> findQuestionsByTestId(Integer testId);


}
