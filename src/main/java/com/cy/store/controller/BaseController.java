package com.cy.store.controller;

import com.cy.store.exception.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/13
 */
public class BaseController {
    public static final int ok = 200;
    // 请求处理方法，这个方法的返回值就是需要传递给前端的数据
    /** 自动将异常对象传递给吃方法的列表参数上*/
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result = new JsonResult<>();

        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生的未知的异常");
        } else if (e instanceof PasswordNotMatchException){
            result.setState(6000);
            result.setMessage("用户密码有误");
        } else if (e instanceof UserNotFoundException){
            result.setState(7000);
            result.setMessage("用户不存在");
        }
        return result;
    }


    protected final Integer getuidFromSession(HttpSession session){
            return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("usename").toString();
    }
}
