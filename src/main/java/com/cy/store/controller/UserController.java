package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.exception.UsernameDuplicatedException;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/12
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(ok);
    }

    @RequestMapping("/login")
    public JsonResult<User> Login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());

        // 获取session中绑定的数据
        System.out.println(getuidFromSession(session));

        return new JsonResult<User>(ok,user);
    }

}
