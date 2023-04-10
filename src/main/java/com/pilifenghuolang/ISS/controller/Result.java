package com.pilifenghuolang.ISS.controller;

public class Result {
    private Object data;
    private Meta meta = new Meta();

    public Result() {
    }

    public Result(Integer code,Object data) {
        this.data = data;
        meta.setCode(code);
    }

    public Result(Integer code, Object data, String msg) {
        this.data = data;
        meta.setCode(code);
        meta.setMsg(msg);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
