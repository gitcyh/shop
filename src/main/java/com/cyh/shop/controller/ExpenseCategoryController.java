package com.cyh.shop.controller;


import com.cyh.shop.bean.ExpenseCategoryBean;
import com.cyh.shop.service.ExpenseCategoryService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryService expenseCategoryService;

    @PostMapping("/sys/addExpenseCategory")
    public Object sys_addExpenseCategory(@RequestBody ExpenseCategoryBean expenseCategoryBean){
        int result = expenseCategoryService.insertSysExpenseCategory(expenseCategoryBean);
        if(result > 0 ){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/sys/getExpenseCategorys")
    public Object sys_getExpenseCategorys(HttpServletRequest request){
        List<ExpenseCategoryBean> list = expenseCategoryService.getSysBrandExpenseCategorys();
        return Result.success().add("data",list);
    }

    @GetMapping("/sys/getExpenseCategory")
    public Object sys_getExpenseCategory(@PathParam("id") String id){
        ExpenseCategoryBean expenseCategoryBean = expenseCategoryService.getExpenseCategory(id);
        if(expenseCategoryBean != null){
            return Result.success().add("data",expenseCategoryBean);
        }
        return  Result.fail();
    }

    @PostMapping("/sys/updateExpenseCategory")
    public Object sys_updateExpenseCategory(@RequestBody ExpenseCategoryBean expenseCategoryBean) {
        int result = expenseCategoryService.updateSysExpenseCategory(expenseCategoryBean);
        if (result > 0) {
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/sys/deleteExpenseCategory")
    public Object sys_deleteExpenseCategory(@PathParam("id") String id){
        int result = expenseCategoryService.deleteSysExpenseCategory(id);
        if(result > 0 ){
            return Result.success();
        }
        return Result.fail();
    }
}
