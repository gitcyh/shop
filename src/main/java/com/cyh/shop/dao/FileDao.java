package com.cyh.shop.dao;

import com.cyh.shop.bean.FileBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileDao {
    int deleteByPrimaryKey(String id);

    int insert(FileBean record);

    FileBean selectByPrimaryKey(String id);

    int updateByPrimaryKeyWithBLOBs(FileBean record);

    int updateByPrimaryKey(FileBean record);
}