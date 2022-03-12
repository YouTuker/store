package com.cy.store.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/10
 */
@Getter
@Setter
@EqualsAndHashCode

/** 用户的实体类 */
public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;
}
