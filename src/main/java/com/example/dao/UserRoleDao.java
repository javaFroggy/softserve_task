package com.example.dao;

import com.example.model.UserRole;

public interface UserRoleDao {
    /**
     * @param id role id
     * @return UserRole object
     */
    UserRole findRoleById(Integer id);
}
