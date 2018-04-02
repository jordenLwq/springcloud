package com.jorden.li.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    public static Result genSuccessResult() {
        Result res=  new Result();
        res.setMessage("success");
        return res;
    }

    public static Result genSuccessResult(Object data) {
        Result res=  new Result();
        res.setData(data);
        res.setMessage("success");
        return res;
    }

    public static Result genFailResult(String message) {
        Result res=  new Result();
        res.setMessage(message);
        return res;
    }
}
