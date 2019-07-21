package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBTools {

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {

        String resources = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        return new SqlSessionFactoryBuilder().build(inputStream);

    }

    public static SqlSession getSqlSession() throws IOException {

        getSqlSessionFactory();

        return null;
    }

}
