package com.cy.store.controller;

import com.cy.store.exception.InsertException;
import com.cy.store.exception.ServiceException;
import com.cy.store.exception.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/13
 */
public class BaseController {
    public static final int ok = 200;
    // 请求处理方法，这个方法的返回值就是需要传递给前端的数据
    // 自动将异常对象传递给吃方法的列表参数上
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result = new JsonResult<>();

        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生的未知的异常");
        }
        return result;
    }
}
