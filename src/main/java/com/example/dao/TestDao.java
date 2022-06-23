package com.example.dao;

import com.example.model.Test;

import java.util.List;

public interface TestDao {

    /**
     * @param testId - id that will be inserted into query
     * @return Test object
     */
    Test findById(Integer testId);

    /**
     * @return List of all tests found
     */
    List<Test> getAllTests();

    /**
     * saves test into DB
     * @param test - Test to save
     */
    void save(Test test);
}
