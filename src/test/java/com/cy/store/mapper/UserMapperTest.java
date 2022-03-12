package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/10
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insert() {
        User user = new User();
        user.setPhone("13170221980");
        user.setUsername("王五");
        user.setPassword("123456");
        System.out.println(userMapper.insert(user));
    }
    @Test
    void getUserByUserName(){
        User yangchuantang = userMapper.getUserByUserName("杨传堂");
        System.out.println(yangchuantang);
    }
}