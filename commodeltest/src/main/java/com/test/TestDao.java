package com.test;

import com.dao.UserDao;
import com.model.UserInfo;
import org.testng.annotations.Test;

public class TestDao {

    @Test
    public void testAddUser() {

        /**
         * 调用 Dao 的方法，测试用户新增
         */

        UserDao userDao=new UserDao();
        UserInfo userInfo=new UserInfo();

        userInfo.setId(123);
        userInfo.setAge(12);
        userDao.add(userInfo);

    }
    @Test
    public void testDeleteUser() {

        /**
         * 调用 Dao 的方法，测试用户新增
         */

        UserDao userDao=new UserDao();
        int id=1;
        userDao.deleteUserById(id);

    }
    @Test
    public void testUpdateUser() {

        /**
         * 调用 Dao 的方法，测试用户更新
         */

        UserDao userDao=new UserDao();
        UserInfo userInfo=new UserInfo();

        userInfo.setId(604);
        userInfo.setAge(18);
        userDao.update(userInfo);

    }
    @Test
    public void testSelectUser() {

        /**
         * 调用 Dao 的方法，测试用户查找
         */

        UserDao userDao=new UserDao();
        int id=10;
        userDao.selectById(id);

    }
}
