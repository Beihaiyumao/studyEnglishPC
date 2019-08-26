package com.neusoft.studyEnglish.dao;

import com.neusoft.studyEnglish.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public  interface UserMapper {
    /***用户注册**/
    void registNewUser(User regist);

    /***用户登录**/
    User login(String email);

    // 修改密码
    int updatePassword(@Param("userId") String userId, @Param("password") String password);
    /***根据用户id查询用户信息*****/
    User selectUserInfoByUserId(String userId);
    /***永久注销用户***/
    int deleteUser(String userId);
    int updateUsername(@Param("userId") String userId, @Param("username") String username);
    //更新用户信息
    int updateUserInfo(User user);
    //更新头像
    int updateHeadPhoto(@Param("path")String path,@Param("userId")String userId);
}
