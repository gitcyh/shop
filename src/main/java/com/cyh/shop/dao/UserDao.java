package com.cyh.shop.dao;

import com.cyh.shop.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(UserBean record);

    UserBean selectByPrimaryKey(String id);

    int updateByPrimaryKey(UserBean record);

    UserBean selectByNamePwd(UserBean record);

    UserBean hasUser(String username);
}