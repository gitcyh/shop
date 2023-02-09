package com.cyh.shop.dao;

import com.cyh.shop.bean.CategoryBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
    int deleteByPrimaryKey(String id);

    int insert(CategoryBean record);

    int insertSelective(CategoryBean record);

    CategoryBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CategoryBean record);

    int updateByPrimaryKey(CategoryBean record);

    List<CategoryBean> selectAll();
}