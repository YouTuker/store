package com.cy.store.service;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/12
 * 用户模块业务层接口
 */

public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户数据对象
     */
    void reg(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     */
    User login(String username, String password);
}
