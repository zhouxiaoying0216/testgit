package dao;

import mapper.UserMapper;
import model.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.annotations.Test;

import java.io.IOException;

import static dao.DBTools.getSqlSessionFactory;

//@Test
public class UserDao {

    private SqlSessionFactory sqlSessionFactory;

    UserInfo userInfo = new UserInfo();

    @Test
    public void testSelectById() throws IOException {

        int id = 1;
        userInfo = selectById(id);
    }

    //查
    public UserInfo selectById(int id) throws IOException {
        //获取sqlsessionFactory
        sqlSessionFactory = getSqlSessionFactory();

        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserInfo userinfo;
        try {

            //获取接口的实现类对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            userinfo = mapper.getUserInfoById(id);

            System.out.println(userinfo.toString());
        } finally {
            sqlSession.close();
        }

        return userinfo;
    }

    //删除
    public void delete() throws IOException {
        //获取sqlsessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //获取sqlsession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {

            //获取接口的实现类对象
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            mapper.deleteUserById(3);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    //添加
    public void add() throws IOException {
        //获取sqlsessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //获取sqlsession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {

            //获取接口的实现类对象
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            UserInfo user = new UserInfo();
            user.setAge(11);

            mapper.addUserInfo(user);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    //更新
    public void update() throws IOException {
        //获取sqlsessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //获取sqlsession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {

            //获取接口的实现类对象
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            UserInfo user = new UserInfo();
            user.setId(603);
            user.setAge(13);
            mapper.updateUserInfoById(user);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }
}
