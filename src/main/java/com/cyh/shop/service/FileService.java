package com.cyh.shop.service;

import com.cyh.shop.bean.FileBean;
import com.cyh.shop.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileDao fileDao;

    public int upload(FileBean fileBean){
        return fileDao.insert(fileBean);
    }

    public FileBean selectByPrimaryKey(String id){
        return fileDao.selectByPrimaryKey(id);
    }
}
