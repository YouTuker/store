package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/12
 */

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService iUserService;
    @Test
    void reg() {
        User user = new User();
        user.setPhone("13170221980");
        user.setUsername("王伟");
        user.setPassword("123456");
        iUserService.reg(user);
    }
}