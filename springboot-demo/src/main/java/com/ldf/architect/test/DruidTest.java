package com.ldf.architect.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.ldf.architect.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class DruidTest {

    /**
     * druid连接池测试
     */

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("SELECT sex, score from user_score order by score limit 50000");
        connection.close();
        System.out.println(1);
    }


}
