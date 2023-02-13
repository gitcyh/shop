package com.cyh.shop.service;

import com.cyh.shop.bean.StaffBean;
import com.cyh.shop.dao.StaffDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffDao staffDao;

    public int addStaff(StaffBean staffBean){
        staffBean.setShopId(UUIDUtil.generateId());
        staffBean.setId(UUIDUtil.generateId());
        return staffDao.insert(staffBean);
    }

    public StaffBean getStaff(String id){
        return staffDao.selectByPrimaryKey(id);
    }

    public int updateStaff(StaffBean staffBean){
        return staffDao.updateByPrimaryKey(staffBean);
    }

    public List<StaffBean> getStaffs (){
        return staffDao.selectAll();
    }

    public int deleteStaff(String id){
        return staffDao.deleteByPrimaryKey(id);
    }
}
