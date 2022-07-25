package com.jdbc.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTest {
@Test
    public void test01() throws PropertyVetoException {
//        创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");

        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象即知道数据库位置在哪
        jdbcTemplate.setDataSource(dataSource);
//        执行操作
        int row = jdbcTemplate.update("insert into account Value(?,?,?)","1","老大",100);

        System.out.println(row);
    }

    @Test
//    spring产生jdbc对象
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        int row = jdbcTemplate.update("insert into account Value(?,?,?)","3","老三",300);

        System.out.println(row);
    }
}
