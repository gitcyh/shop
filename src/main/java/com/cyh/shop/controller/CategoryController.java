package com.cyh.shop.controller;


import com.cyh.shop.bean.CategoryBean;
import com.cyh.shop.service.CategoryService;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/sys/getCategorys")
    public Object getCategorys(HttpServletRequest request){
        List<CategoryBean> list = categoryService.getCategoryBeanList();
        return Result.success().add("data",list);
    }

    @PostMapping("/sys/addCategory")
    public Object addCategory(@RequestBody CategoryBean categoryBean){
        int result = categoryService.addCategory(categoryBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/sys/getCategory")
    public Object getCategory(@PathParam("id") String id){
        CategoryBean categoryBean = categoryService.getCategoryById(id);
        if(categoryBean != null){
            return Result.success().add("data",categoryBean);
        }
        return Result.fail();
    }

    @PostMapping("/sys/updateCategory")
    public Object updateCategory(@RequestBody CategoryBean categoryBean){
        int result = categoryService.updateCategory(categoryBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/sys/deleteCategory")
    public Object deleteCategory(@PathParam("id") String id){
        int result = categoryService.deleteCategoryById(id);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }
}
