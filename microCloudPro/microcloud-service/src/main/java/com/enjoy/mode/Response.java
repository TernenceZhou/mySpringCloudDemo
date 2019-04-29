package com.enjoy.mode;

import com.enjoy.mode.base.BaseResponse;

public class Response<T> extends BaseResponse {

    public static final String SUCCESS = "0000";
    public static final String FAILD = "9999";
    public final static String API_NO_ACCESS = "0001";
    public final static String API_SIGN_ERROR = "0002";
    public final static String API_NOT_AVAILABLE = "0003";
    public final static String API_PARAMS_ERROR = "0004";

    public final static String OTHER_API_NO_ACCESS = "9898";
    public final static String RE_REQUEST = "9899";
    public final static String TOKEN_ERROR = "9997";

    private String result;
    private String msg;
    private T obj;

    public Response() {
    }

    public Response(String result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public Response(String result, String msg, T obj) {
        this.result = result;
        this.msg = msg;
        this.obj = obj;
    }

    public String getResult() {
        return result;
    }

    public Response setResult(String result) {
        this.result = result;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getObj() {
        return obj;
    }

    public Response setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public static Response s(){
        return new Response(SUCCESS,"处理成功");
    }
    public static Response e(){
        return new Response(FAILD,"处理失败");
    }
}
