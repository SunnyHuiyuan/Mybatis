package com.local.dao;

import com.local.pojo.User;
import com.local.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lou ke
 * @version 1.0
 * @date 2020/2/21 16:20
 */
public class UserTest {
    @Test
    public void test() {
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

    @Test
    public void testGetUserById() {
        //获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行接口的方法
        User user = mapper.getUserById(1);
        System.out.println(user);


        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.addUser(new User(4, "sunny", "333444"));
        if (result > 0) {
            System.out.println("插入成功！");
        }
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4, "更改后", "223334"));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);
        sqlSession.commit();

        sqlSession.close();
    }
}
