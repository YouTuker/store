package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.exception.InsertException;
import com.cy.store.exception.PasswordNotMatchException;
import com.cy.store.exception.UserNotFoundException;
import com.cy.store.exception.UsernameDuplicatedException;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

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

        // 密码加密处理 ：md5
        // 盐值 + password + 盐值 ----盐值就是一个随机的字符串而已
        String oldPassword = user.getPassword();
        // 获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 将密码和盐值作为一个整体进行加密操作
        String md5Password = getMD5Password(oldPassword, salt);

        // 执行注册业务功能的实习,
        user.setPassword(md5Password);
        user.setSalt(salt);
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

    /** 定义一个md5算法的加密处理 */
    private String getMD5Password (String password, String salt){
        // md5加密算法
        DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        for(int i = 0;i<3;i++){
           password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        // 加密之后的操作

        return password;
    }

    @Override
    public User login(String username, String password){
        User userByUserName = userMapper.getUserByUserName(username);
        if (userByUserName==null){
            throw new UserNotFoundException();
        }
        if (!password.equals(userByUserName.getPassword())){
            throw new PasswordNotMatchException();
        }

        return userByUserName;

    }
}
