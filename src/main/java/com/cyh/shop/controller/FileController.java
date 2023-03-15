package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.service.FileService;
import com.cyh.shop.util.EditorUploadResult;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;

@RestController
@RequestMapping("/pc")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public Object upload(MultipartFile file, HttpServletRequest requset){
        try {
            JSONObject jsonObject = fileService.upload(file);
            if(jsonObject.getInteger("code") > 0){
                return Result.success().add("fileId",jsonObject.getString("id"));
            }
        } catch (IOException e) {
            return Result.fail("文件上传失败");
        }
        return Result.fail("文件上传失败");
    }


    @PostMapping("/editor/upload")
    public Object editorUpload(MultipartFile file, HttpServletRequest requset){
        try {
            JSONObject jsonObject = fileService.upload(file);
            if(jsonObject.getInteger("code") > 0){
                return EditorUploadResult.success().add("url","/api/editor/download?id="+jsonObject.getString("id"));
            }
        } catch (IOException e) {
            return EditorUploadResult.fail();
        }
        return EditorUploadResult.fail();
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

    /**
     * @param id 文件id
     * @param response
     * @功能描述 下载文件:
     */
    @GetMapping("/editor/download")
    public void editorDownload(@PathParam("id") String id, HttpServletResponse response) {
        try {
            fileService.download(id,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/deleteFile")
    public Object deleteFile(@RequestBody JSONObject jsonObject){
        JSONArray list = jsonObject.getJSONArray("list");
        int result = fileService.deleteFileByIds(list);
        if(result > 0){
            return Result.success("成功删除"+result+"条数据");
        }
        return  Result.fail();
    }


}
