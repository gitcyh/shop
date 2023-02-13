package com.cyh.shop.service;

import com.cyh.shop.bean.ExpenseCategoryBean;
import com.cyh.shop.dao.ExpenseCategoryDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {

    @Autowired
    private ExpenseCategoryDao expenseCategoryDao;

    public List<ExpenseCategoryBean> getSysBrandExpenseCategorys(){
        return expenseCategoryDao.selectAll();
    }

    public int insertSysExpenseCategory(ExpenseCategoryBean expenseCategoryBean){
        expenseCategoryBean.setId(UUIDUtil.generateId());
        return expenseCategoryDao.insert(expenseCategoryBean);
    }

    public ExpenseCategoryBean getExpenseCategory(String id){
        return expenseCategoryDao.selectByPrimaryKey(id);
    }

    public int updateSysExpenseCategory(ExpenseCategoryBean expenseCategoryBean){
        return expenseCategoryDao.updateByPrimaryKey(expenseCategoryBean);
    }

    public int deleteSysExpenseCategory(String id){
        return expenseCategoryDao.deleteByPrimaryKey(id);
    }
}
