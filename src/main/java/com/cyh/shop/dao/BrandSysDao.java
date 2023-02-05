package com.cyh.shop.dao;

import com.cyh.shop.bean.BrandSysBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandSysDao {
    int deleteByPrimaryKey(String id);

    int insert(BrandSysBean brandSysBean);


    BrandSysBean selectByPrimaryKey(String id);


    int updateById(BrandSysBean record);


    List<BrandSysBean> selectBrandAll();
}