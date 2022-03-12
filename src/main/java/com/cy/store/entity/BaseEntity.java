package com.cy.store.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/10
 */
@Data
@Getter
@Setter
public class BaseEntity implements Serializable {
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
