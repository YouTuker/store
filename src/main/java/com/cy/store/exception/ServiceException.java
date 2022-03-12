package com.cy.store.exception;

import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/12
 */
@Component
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
