package com.pilifenghuolang.ISS.controller;

public class Result {
    private Object data;
    private Meta meta;

    public Result() {
    }

    public Result(Integer code,Object data) {
        this.data = data;
        this.meta.code = code;
    }

    public Result(Integer code, Object data, String msg) {
        this.data = data;
        this.meta.code = code;
        this.meta.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return meta.code;
    }

    public void setCode(Integer code) {
        this.meta.code = code;
    }

    public String getMsg() {
        return meta.msg;
    }

    public void setMsg(String msg) {
        this.meta.msg = msg;
    }
}
