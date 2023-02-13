package com.cyh.shop.service;

import com.cyh.shop.bean.DespositBean;
import com.cyh.shop.dao.DespositDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespositService {

    @Autowired
    private DespositDao despositDao;

    /**
     * 添加押金单
     * @param despositBean
     * @return
     */
    public int addDesposit(DespositBean despositBean){
        despositBean.setId(UUIDUtil.generateId());
        return despositDao.insert(despositBean);
    }

    public int deleteDesposit(String id){
        return despositDao.deleteByPrimaryKey(id);
    }

    public int updateDesposit(DespositBean despositBean){
        return despositDao.updateByPrimaryKey(despositBean);
    }

    public DespositBean getDesposit(String id){
        return despositDao.selectByPrimaryKey(id);
    }

    public List<DespositBean> getDesposits(){
        return despositDao.selectAll();
    }



}
