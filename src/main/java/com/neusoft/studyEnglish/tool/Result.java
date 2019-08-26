package com.neusoft.studyEnglish.tool;

/**
 * 返回结果封装
 */
public class Result {
    //防止自己被实例化
    private Result(){}
    private String msg;
    private Object object;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Result(int code, String msg, Object object) {
        this.msg = msg;
        this.object = object;
        this.code=code;
    }
    public Result(int code,String msg) {
        this.code=code;
        this.msg = msg;

    }
    public static Result ok(int code,String msg, Object object){
        return new Result(code,msg,object);
    }
    public static Result ok(int code,String msg){
        return new Result(code,msg);
    }
    public static Result error(int code,String msg, Object object){
        return new Result(code,msg,object);
    }
    public static Result error(int code,String msg){
        return new Result(code,msg);
    }
}
