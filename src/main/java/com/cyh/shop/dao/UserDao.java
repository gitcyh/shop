package com.cyh.shop.dao;

import com.cyh.shop.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(UserBean record);

    UserBean selectUserById(String id);

    UserBean selectUserByUserName(String username);

    int updateUserById(UserBean record);

    UserBean selectByNamePwd(UserBean record);

    UserBean hasUser(String username);
}