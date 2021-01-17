package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserList();

    List<User> getUserListByLimit(Map<String, Integer> map);
}
