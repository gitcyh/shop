package com.cyh.shop.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.CustomerBean;
import com.cyh.shop.service.CustomerService;
import com.cyh.shop.util.Result;
import com.cyh.shop.util.UUIDUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/addCustomer")
    public Object addCustomer(@RequestBody CustomerBean customerBean) {
        int result = customerService.addCustomer(customerBean);
        if (result > 0) {
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/getCustomer")
    public Object getCustomer(@PathParam("id") String id) {
        CustomerBean customerBean = customerService.getCustomer(id);
        if (customerBean != null) {
            return Result.success().add("data", customerBean);
        }
        return Result.fail();
    }

    @PostMapping("/updateCustomer")
    public Object updateCustomer(@RequestBody CustomerBean customerBean) {
        int result = customerService.updateCustomer(customerBean);
        if (result > 0) {
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/getCustomers")
    public Object getCustomers(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        List<CustomerBean> list = customerService.getCustomers(shopId,currentPage,pageSize);
        return Result.success().add("data", list);
    }

    @GetMapping("/getCountCustomers")
    public Object getCountCustomers(@PathParam("shopId") String shopId) {
        int result = customerService.getCountCustomers(shopId);
        return Result.success().add("data",result);
    }

    @GetMapping("/deleteCustomer")
    public Object deleteCustomer(@PathParam("id") String id) {
        int result = customerService.deleteCustomer(id);
        if (result > 0) {
            return Result.success();
        }
        return Result.fail();
    }

    /**
     * 客户文件导入功能
     *
     * @param file
     * @param requset
     * @return
     */
    @PostMapping("/uploadCustomer")
    public Object uploadCustomer(MultipartFile file, HttpServletRequest requset) {
        try {
            String shopId = requset.getParameter("shopId");
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            List<Sheet> sheets = reader.getSheets();
            Map<String,Object> map = new HashMap<>();//去重集合根据地址去重
            for(Object key : sheets){
                Sheet sheet = (Sheet) key;
                String sheetName = sheet.getSheetName();
                ExcelReader reader1 = ExcelUtil.getReader(file.getInputStream(), sheetName);
                List<Map<String, Object>> readAlls = reader1.read(1, 2, Integer.MAX_VALUE);
                for (Map<String, Object> s : readAlls) {
                    for (String k : s.keySet()) {
                        if(k.trim().equals("客户地址") && s.get(k) != null && !s.get(k).toString().trim().equals("")){
                            String value = s.get(k).toString().trim();
                            if(!value.contains("自提")) {
                                map.put(s.get(k).toString(), s);
                                break;
                            }
                        }
                    }
                }
            }
            int result = customerService.uploadCustomers(map,shopId);
            if(result > 0){
                return Result.success().add("data",result);
            }
        } catch (IOException e) {
            return Result.fail();
        }
        return Result.fail();
    }
}
