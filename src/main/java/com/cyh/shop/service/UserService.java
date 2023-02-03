package com.cyh.shop.service;

import com.cyh.shop.bean.UserBean;
import com.cyh.shop.dao.UserDao;
import com.cyh.shop.util.Md5Util;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public UserBean selectUserByNamePwd(UserBean userBean){
        return  userDao.selectByNamePwd(userBean);
    }

    public int inserUser(UserBean userBean){
        UserBean hasUser = userDao.hasUser(userBean.getUsername());//查询是否存在该用户
        if(hasUser == null){
            userBean.setId(UUIDUtil.generateId());
            return  userDao.insert(userBean);
        }else{
            return -1;
        }
    }
}
