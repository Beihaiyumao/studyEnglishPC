package com.neusoft.studyEnglish.tool;

/**
 * 返回信息封装
 */
public interface ResultStateInfo {
    String UPDATE_SUCCESS = "修改成功";
    String UPDATE_FAIL = "修改失败";
    String DELTE_SUCCESS = "删除成功";
    String DELETE_FAIL = "删除失败";
    String SELECT_SUCCESS = "查询成功";
    String SELECT_FAIL = "查询失败";
    String ALREADY_REGIST = "该用户已被注册，请直接登录";
    String REGIST_SUCCESS = "注册成功";
    String LOGIN_SUCCESS = "登录成功";
    String USERNAME_ERROR = "用户名错误";
    String PASSWORD_ERROR = "密码错误";
    String OLDPASSWORD_ERROR = "原密码错误";
    String LOGOFF_SUCCESS = "注销成功";
    String LOGOFF_FAIL = "注销失败";
    String SUCCESS="操作成功";
    String FAIL="操作失败";
    String PHOTO_TYPE="只支持png，jgp后缀的图片";
    String UPLOAD_SUCCESS="上传成功";
    String UPLOAD_FAIL="上传失败";
    String NO_KNOW_FAIL="未知错误,请重试";
}
