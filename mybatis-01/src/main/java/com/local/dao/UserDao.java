package com.local.dao;

import com.local.pojo.User;

import java.util.List;

/**
 * @author lou ke
 * @version 1.0
 * @date 2020/2/21 15:53
 */
public interface UserDao {
    List<User> getUserList();
}
