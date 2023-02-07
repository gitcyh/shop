package com.cyh.shop.util;

import java.util.HashMap;
import java.util.Map;

public class EditorUploadResult {
    private Map<String,Object> data = new HashMap<>();//返回数据

    private int errno;// 富文本编辑器上传文件返回的状态码0表示成功其他表示失败

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public EditorUploadResult(int errno) {
        this.errno = errno;
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "errno:" + errno +
                ",data:" + data +
                "}";
    }

    public static EditorUploadResult success(){
        return new EditorUploadResult(0);
    }

    public static EditorUploadResult fail(){
        return new EditorUploadResult(500);
    }

    public static EditorUploadResult error(int code){
        return new EditorUploadResult(code);
    }



    public EditorUploadResult add(String key, Object value){
        this.data.put(key, value);
        return this;
    }

}
