package test;

import dao.UserDao;
import model.UserInfo;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestDao {


    @Test
    public void testSelectById() throws IOException {

        UserInfo userInfo = new UserInfo();

        UserDao userDao = new UserDao();

        int id = 1;
        userInfo = userDao.selectById(id);
    }

}
