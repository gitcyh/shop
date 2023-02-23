package com.cyh.shop.service;

import com.cyh.shop.bean.PayoutBean;
import com.cyh.shop.dao.PayoutDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PayoutService {

    @Autowired
    private PayoutDao payoutDao;

    public int addPayout(PayoutBean payoutBean){
        payoutBean.setId(UUIDUtil.generateId());
        return payoutDao.insert(payoutBean);
    }

    public int updatePayout(PayoutBean payoutBean){
        return payoutDao.updateByPrimaryKey(payoutBean);
    }

    public int deletePayout(String id){
        return payoutDao.deleteByPrimaryKey(id);
    }

    public PayoutBean getPayout(String id){
        return payoutDao.selectByPrimaryKey(id);
    }

    public List<Map> getPayoutList(String shopId,String type,String date){
        return payoutDao.getPayoutList(shopId, type, date);
    }

    public List<Map> getPayoutChart(String shopId){
        return payoutDao.selectPayoutList(shopId);
    }
}
