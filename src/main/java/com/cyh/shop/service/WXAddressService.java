package com.cyh.shop.service;


import com.cyh.shop.bean.WXAddressBean;
import com.cyh.shop.dao.WXAddressDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WXAddressService {

    @Autowired
    private WXAddressDao wxAddressDao;

    public int addAddress(WXAddressBean wxAddressBean){
        String id = UUIDUtil.generateId();
        wxAddressBean.setId(id);
        if(wxAddressBean.getIsDefault() == 1){
            updateDefault(id);
        }
        return wxAddressDao.insert(wxAddressBean);
    }

    public int deleteAddress(String id){
        return wxAddressDao.deleteByPrimaryKey(id);
    }

    public int updateAddress(WXAddressBean wxAddressBean){
        return wxAddressDao.updateByPrimaryKeySelective(wxAddressBean);
    }

    public List<WXAddressBean> getAddressList(String userid){
        return wxAddressDao.selectAddressList(userid);
    }

    public WXAddressBean getAddress(String id){
        return wxAddressDao.selectByPrimaryKey(id);
    }

    public int updateDefault(String id){
        return wxAddressDao.updateDefault(id);
    }
}
