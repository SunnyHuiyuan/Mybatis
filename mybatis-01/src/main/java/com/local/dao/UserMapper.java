package com.local.dao;

import com.local.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author lou ke
 * @version 1.0
 * @date 2020/2/21 15:53
 */
public interface UserMapper {

    //模糊查询
    List<User> getUserLike(String value);

    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    User getUserById2(Map<String, Object> map);

    //增加一个用户
    int addUser(User user);

    //万能的map
    int addUser2(Map<String, Object> map);

    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);
}
