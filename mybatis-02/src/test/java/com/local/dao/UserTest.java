package com.local.dao;

import com.local.pojo.User;
import com.local.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lou ke
 * @version 1.0
 * @date 2020/2/21 16:20
 */
public class UserTest {

    @Test
    public void testGetUserList() {
        //1.获取执行sql操作的sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //方式一：getMapper获取接口，从而来执行SQL操作
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

}
