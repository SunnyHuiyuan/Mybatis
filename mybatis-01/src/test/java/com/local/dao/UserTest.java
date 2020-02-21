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

    //模糊查询
    @Test
    public void testGetUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%李%");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

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

    /*
     * Map传递参数，直接在sql中取出key即可                     parameterType="map"
     * 对象传递参数，直接在sql中取出对象的属性即可              parameterType="Object"
     * 只有一个基本类型参数的情况下，可以直接在sql中取到       省略
     * 多个参数用 Map,或者注解
     * */
    @Test
    public void testGetUserById2() {
        //获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行接口的方法
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 3);
        map.put("name", "王五");
        System.out.println(mapper.getUserById2(map));


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

    //字段太多用Map
    @Test
    public void testAddUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", 5);
        map.put("name1", "hello");
        map.put("password1", "1996098");
        mapper.addUser2(map);

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
