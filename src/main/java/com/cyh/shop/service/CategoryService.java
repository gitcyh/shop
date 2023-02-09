package com.cyh.shop.service;


import com.cyh.shop.bean.CategoryBean;
import com.cyh.shop.dao.CategoryDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<CategoryBean> getCategoryBeanList(){
        return categoryDao.selectAll();
    }

    public int addCategory(CategoryBean categoryBean){
        categoryBean.setId(UUIDUtil.generateId());
        return categoryDao.insert(categoryBean);
    }

    public CategoryBean getCategoryById(String id){
        return categoryDao.selectByPrimaryKey(id);
    }

    public int updateCategory(CategoryBean categoryBean){
        return categoryDao.updateByPrimaryKey(categoryBean);
    }

    public int deleteCategoryById(String id){
        return categoryDao.deleteByPrimaryKey(id);
    }


}
