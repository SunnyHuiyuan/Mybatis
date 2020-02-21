package com.local.dao;

import com.local.pojo.User;

import java.util.List;

/**
 * @author lou ke
 * @version 1.0
 * @date 2020/2/21 15:53
 */
public interface UserMapper {

    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //增加一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);
}
