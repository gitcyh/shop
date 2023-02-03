package com.cyh.shop.util;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private int code;//请求响应码 200成功,500失败

    private String msg;//提示信息

    private Map<String,Object> data = new HashMap<>();//返回数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(){
        Result result = new Result(200,"success");
        return result;
    }

    public static Result fail(String... msg){
        if(msg.length == 0){
            return new Result(500,"fail");
        }else{
            return new Result(500,msg[0]);
        }
    }

    public Result add(String key, Object value){
        this.data.put(key, value);
        return this;
    }

}
