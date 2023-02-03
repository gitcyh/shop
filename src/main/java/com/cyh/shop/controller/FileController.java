package com.cyh.shop.controller;

import com.cyh.shop.bean.FileBean;
import com.cyh.shop.service.FileService;
import com.cyh.shop.util.Result;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public Object upload(MultipartFile file, HttpServletRequest requset){
        try {
            String name = file.getOriginalFilename();
            int last = name.lastIndexOf(".");
            String fileName = name.substring(0,last);
            String type = name.substring(last+1,name.length());
            FileBean fileBean = new FileBean();
            fileBean.setId(UUIDUtil.generateId());
            fileBean.setFileName(fileName);
            fileBean.setFileType(type);
            fileBean.setFileSize(file.getSize());
            fileBean.setContent(file.getBytes());
            fileService.upload(fileBean);
        } catch (IOException e) {
            return Result.fail("文件上传失败");
        }
        return Result.success();
    }



    /**
     * @param id 文件id
     * @param response
     * @功能描述 下载文件:
     */
    @GetMapping("/download")
    public void download(@PathParam("id") String id, HttpServletResponse response) {
        try {
            FileBean fileBean = fileService.selectByPrimaryKey(id);
            if(fileBean != null) {
                byte[] content = fileBean.getContent();
                String fileName = fileBean.getFileName() + "." + fileBean.getFileType();
                // 清空response
                response.reset();
                // 设置response的Header
                response.setCharacterEncoding("UTF-8");
                //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
                //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
                // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
                response.addHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                // 告知浏览器文件的大小
                response.addHeader("Content-Length", "" + fileBean.getFileSize());
                OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                outputStream.write(content);
                outputStream.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
