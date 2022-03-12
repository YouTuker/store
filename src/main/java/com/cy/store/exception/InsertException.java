package com.cy.store.exception;

import org.springframework.stereotype.Component;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/12
 * 数据在插入过程的产生的异常
 */
@Component
public class InsertException extends ServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
