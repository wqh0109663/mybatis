package top.show.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import top.show.entity.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-4-14 下午2:29
 */
public class UserDaoTest {
    @Test
    public void testGetUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUser(1L);
        sqlSession.close();
        Assert.assertNotNull(user);
    }


}