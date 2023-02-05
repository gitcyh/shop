package com.cyh.shop.service;

import com.cyh.shop.bean.BrandSysBean;
import com.cyh.shop.dao.BrandSysDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandSysDao brandSysDao;

    public int insertSysBrand(BrandSysBean brandSysBean){
        brandSysBean.setId(UUIDUtil.generateId());
        return  brandSysDao.insert(brandSysBean);
    }

    public List<BrandSysBean> getSysBrandList(){
        return  brandSysDao.selectBrandAll();
    }

    public int updateSysBrand(BrandSysBean brandSysBean){
        return brandSysDao.updateById(brandSysBean);
    }


}
