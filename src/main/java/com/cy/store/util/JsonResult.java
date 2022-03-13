package com.cy.store.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<E> implements Serializable {
    /** 状态码 */
    private Integer state;
    private String message;
    private E data;

    public JsonResult(Integer state){
        this.state = state;
    }
    public JsonResult(Integer state, E data){
        this.state = state;
        this.data = data;
    }

}
