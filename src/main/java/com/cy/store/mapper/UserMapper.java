package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangchuantang
 * @email uct20210715@163.com
 * @date 2022/3/10
 */
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户的数据
     * @return 收影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return 用户信息
     */
    User getUserByUserName(@Param("userName") String userName);
}
