package com.cyh.shop.controller;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.ShopBean;
import com.cyh.shop.service.ShopService;
import com.cyh.shop.util.Result;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
public class ShopController {


    public static void main(String[] args) {
        String fileName = "E:\\exportData\\GeoTIF\\disp_20220602_ll.tif";
        try {
            BufferedImage bufferedImage = ImageIO.read(FileUtil.getInputStream(fileName));
            if(bufferedImage == null){
                System.out.println("image read null");
            }else{
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();
                for(int i=0;i<width;i++){
                    for(int j=0;j<height;j++){
                        int  data = bufferedImage.getData().getSample(j,i,0);
                        System.out.println(data);
//                        if(data != 0){
//                            System.out.println(data);
//                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ShopService shopService;

    @PostMapping("/addShop")
    public Object addShop(@RequestBody ShopBean shopBean){
        String id = UUIDUtil.generateId();
        shopBean.setId(id);
        int result = shopService.addShop(shopBean);
        if(result > 0){
            return Result.success().add("shopId",id);
        }
        return  Result.fail();
    }

    @PostMapping("/updateShop")
    public Object updateShop(@RequestBody ShopBean shopBean){
        int result = shopService.updateShop(shopBean);
        if(result > 0){
            return Result.success();
        }
        return  Result.fail();
    }

    @GetMapping("/getShop")
    public Object getShop(HttpServletRequest request){
        String id = request.getParameter("id");
        String userId = request.getParameter("userId");
        ShopBean shopBean = null;
        if(id != null){
            shopBean = shopService.getShopById(id);
        }
        if(userId !=null){
            shopBean = shopService.getShopByUserId(userId);
        }
        if(shopBean != null){
            return Result.success().add("data",shopBean);
        }
        return  Result.fail();
    }

    @GetMapping("/sys/deleteShop")
    public Object deleShop(@PathParam("id") String id){
        int result = shopService.deleteShop(id);
        if(result > 0){
            return Result.success();
        }
        return  Result.fail();
    }

    @PostMapping("/sys/getShops")
    public Object getShops(){
        List<ShopBean> list = shopService.getShops();
        return Result.success().add("data",list);
    }

    /**
     * 审核店铺
     * @param jsonObject
     * @return
     */
    @PostMapping("/sys/checkShop")
    public Object checkShop(@RequestBody JSONObject jsonObject, HttpServletRequest request){
        String id = jsonObject.getString("id");
        Integer applyStatus = jsonObject.getInteger("applyStatus");
        String applyDesc = jsonObject.getString("applyDesc");
        int result = shopService.checkShop(id,applyStatus,applyDesc);
        if(result > 0){
            return Result.success();
        }
        return  Result.fail();
    }


}
