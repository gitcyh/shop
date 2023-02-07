package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.BrandSysBean;
import com.cyh.shop.service.BrandService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/sys/addBrand")
    public Object sys_addBrand(@RequestBody BrandSysBean brandSysBean){
        int result = brandService.insertSysBrand(brandSysBean);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("/sys/getBrandList")
    public Object sys_getBrandList(HttpServletRequest request){
        List<BrandSysBean> brands = brandService.getSysBrandList();
        return Result.success().add("data",brands);
    }

    @PostMapping("/sys/updateBrand")
    public Object sys_updateBrand(@RequestBody BrandSysBean brandSysBean){
        int result = brandService.updateSysBrand(brandSysBean);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("/sys/deleteBrand")
    public Object sys_deleteBrand(@RequestBody JSONObject jsonObject){
        String id = jsonObject.getString("id");
        int result = brandService.deleteSysBrand(id);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }
}
