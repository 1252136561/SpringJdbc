package com.jdbc.test;

import com.jdbc.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class jdbcCRUDtest {



    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test

public void testUpdate(){
    jdbcTemplate.update("update account set money=? where name = ?",1000,"老二");
}



@Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name = ?","老二");
    }

    @Test
    public void testSelect(){
//<用户类>(用户类.clas)

        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }
    @Test

    public void testSelect02(){
//<用户类>(用户类.clas)

         Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class),"1");
        System.out.println(account);
    }


    @Test

    public void testSelect03(){
//<用户类>(用户类.clas)

        Long count = jdbcTemplate.queryForObject("select count(*) from account ", Long.class);
        System.out.println(count);
    }
}