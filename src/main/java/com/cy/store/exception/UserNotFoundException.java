package com.cy.store.exception;

import org.springframework.stereotype.Component;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/13
 */
@Component
public class UserNotFoundException extends ServiceException{
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
