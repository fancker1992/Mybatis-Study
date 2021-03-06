package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);

    List<User> getUserLike(String value);

    void addUser(User user);

    void updataUser(int id);

    void deleteUser(int id);
}
