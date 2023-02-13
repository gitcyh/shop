package com.cyh.shop.dao;

import com.cyh.shop.bean.ExpenseCategoryBean;

public interface ExpenseCategoryDao {
    int deleteByPrimaryKey(String id);

    int insert(ExpenseCategoryBean record);

    int insertSelective(ExpenseCategoryBean record);

    ExpenseCategoryBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExpenseCategoryBean record);

    int updateByPrimaryKey(ExpenseCategoryBean record);
}