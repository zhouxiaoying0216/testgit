package com.dao;

import com.mapper.UserMapper;
import com.model.UserInfo;
import com.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserDao {

    private SqlSession sqlSession;
    private UserInfo userinfo;

    @Test
    public UserInfo selectById(int id) {

        try {
            sqlSession = DBUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            userinfo = mapper.getUserInfoById(id);
            System.out.println(userinfo.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return userinfo;
    }
    @Test
    public void deleteUserById(int id)  {


        try {
            sqlSession = DBUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.deleteUserById(id);
            sqlSession.commit();
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void add(UserInfo userinfo)  {

        try {

            sqlSession = DBUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.addUserInfo(userinfo);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void update(UserInfo userinfo)  {

        try {

            //获取接口的实现类对象
            sqlSession = DBUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);


            mapper.updateUserInfoById(userinfo);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
