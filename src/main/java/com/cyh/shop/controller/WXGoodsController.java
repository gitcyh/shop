package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.GoodsBean;
import com.cyh.shop.service.FileService;
import com.cyh.shop.service.WXGoodsService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WXGoodsController {

    @Autowired
    private WXGoodsService wxGoodsService;

    @Autowired
    private FileService fileService;

    @PostMapping("/getGoodsList")
    public Object getGoodsList(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        List<GoodsBean> goodsBeans = wxGoodsService.getWxGoodsList(shopId);
        return Result.success().add("data",goodsBeans);
    }

    /**
     * @param id 文件id
     * @param response
     * @功能描述 下载文件:
     */
    @GetMapping("/download")
    public void download(@PathParam("id") String id, HttpServletResponse response) {
        try {
            fileService.download(id,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
