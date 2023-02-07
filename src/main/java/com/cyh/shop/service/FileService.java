package com.cyh.shop.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.FileBean;
import com.cyh.shop.dao.FileDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@Service
public class FileService {

    @Autowired
    private FileDao fileDao;

    public JSONObject upload(MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        int last = name.lastIndexOf(".");
        String fileName = name.substring(0,last);
        String type = name.substring(last+1,name.length());
        FileBean fileBean = new FileBean();
        String id = UUIDUtil.generateId();
        fileBean.setId(id);
        fileBean.setFileName(fileName);
        fileBean.setFileType(type);
        fileBean.setFileSize(file.getSize());
        fileBean.setContent(file.getBytes());
        int result = fileDao.insert(fileBean);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",result);
        jsonObject.put("id",id);
        return jsonObject;
    }

    public void download(String id, HttpServletResponse response) throws IOException {
        FileBean fileBean = selectByPrimaryKey(id);
        if (fileBean != null) {
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
    }

    public FileBean selectByPrimaryKey(String id){
        return fileDao.selectByPrimaryKey(id);
    }

    public int deleteFileByIds(JSONArray list){
        return fileDao.deleteByIds(list);
    }
}
