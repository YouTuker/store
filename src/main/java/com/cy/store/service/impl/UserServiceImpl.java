package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.exception.InsertException;
import com.cy.store.exception.UsernameDuplicatedException;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/12
 * 用户业务模块的实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        // 查询用户名是否已经注册
        User result = userMapper.getUserByUserName(user.getUsername());
        if (result != null){
            // 抛出用户名被占用异常
            throw new UsernameDuplicatedException("用户名被占用");
        }

        // 执行注册业务功能的实习,
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getCreatedUser());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("用户注册过程中,产生异常");
        }


    }
}
