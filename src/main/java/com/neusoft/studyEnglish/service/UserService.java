package com.neusoft.studyEnglish.service;

import com.neusoft.studyEnglish.dao.UserMapper;
import com.neusoft.studyEnglish.entity.Collections;
import com.neusoft.studyEnglish.entity.User;
import com.neusoft.studyEnglish.tool.Result;
import com.neusoft.studyEnglish.tool.ResultStateInfo;
import com.neusoft.studyEnglish.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param regist
     */
    public Result registNewUser(User regist) {
        User user = userMapper.login(regist.getEmail());
        if (user != null) {
            return Result.error(200, ResultStateInfo.ALREADY_REGIST);
        } else {
            //用户id
            regist.setUserId(SystemTool.uuid());
            userMapper.registNewUser(regist);
            return Result.ok(100, ResultStateInfo.REGIST_SUCCESS);
        }
    }

    /**
     * 用户登陆
     */
    public Result login(User user) {
        User user1 = userMapper.login(user.getEmail());
        if (user1 == null) {
            return Result.error(200, ResultStateInfo.USERNAME_ERROR);
        } else if (!user.getPassword().equals(user1.getPassword())) {
            return Result.error(300, ResultStateInfo.PASSWORD_ERROR);
        } else {
            return Result.ok(100, ResultStateInfo.LOGIN_SUCCESS, user1);
        }
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param password
     * @return
     */
    public Result updatePassword(String userId, String password, String oldpassword) {
        User user = selectUserInfoByUserId(userId);
        if (!oldpassword.equals(user.getPassword())) {
            return Result.error(200, ResultStateInfo.OLDPASSWORD_ERROR);
        } else {
            userMapper.updatePassword(userId, password);
            return Result.ok(100, ResultStateInfo.UPDATE_SUCCESS);
        }
    }

    /*****根据用户Id查询用户信息****/
    public User selectUserInfoByUserId(String userId) {
        return userMapper.selectUserInfoByUserId(userId);
    }

    /**
     * 永久注销用户
     *
     * @param userId
     * @return
     */
    public Result deleteUser(String userId) {
        int code = userMapper.deleteUser(userId);
        if (code == 1) {
            return Result.ok(100, ResultStateInfo.LOGOFF_SUCCESS);
        } else {
            return Result.error(200, ResultStateInfo.LOGOFF_FAIL);
        }
    }

    /**
     * 修改昵称
     *
     * @param userId
     * @param username
     * @return
     */
    public Result updateUsername(String userId, String username) {
        int code = userMapper.updateUsername(userId, username);
        if (code == 1) {
            return Result.ok(100, ResultStateInfo.UPDATE_SUCCESS);
        } else {
            return Result.error(200, ResultStateInfo.UPDATE_FAIL);
        }
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public Result updateUserInfo(User user) {
        int code = userMapper.updateUserInfo(user);
        if (code == 1) {
            return Result.ok(100, ResultStateInfo.UPDATE_SUCCESS, true);
        } else {
            return Result.error(200, ResultStateInfo.UPDATE_FAIL, false);
        }

    }

    /**
     * 上传头像
     *
     * @param fileName
     * @return
     */
    public Result updateHeadPhoto(String fileName, String userId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        int code = userMapper.updateHeadPhoto("img/headPhoto/" + time + "/" + fileName, userId);
        if (code == 1) {
            return Result.ok(100, ResultStateInfo.UPLOAD_SUCCESS, true);
        } else {
            return Result.error(200, ResultStateInfo.UPLOAD_FAIL, false);
        }
    }

    /**
     * 根据类别查询收藏的作文和翻译
     *
     * @param userId
     * @param type
     * @return
     */
    public Result zfCollectionList(String userId, String type) {
        List<Collections> zfCollectionList = userMapper.zfCollectionList(userId, type);
        if (zfCollectionList.size() != 0) {
            return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, zfCollectionList);
        } else {
            return Result.error(200, ResultStateInfo.SELECT_FAIL);
        }
    }

    /**
     * 根据类别查询收藏的听力和阅读
     *
     * @param userId
     * @param type
     * @return
     */
    public Result lrCollectionList(String userId, String type) {
        List<Collections> lrCollectionList = userMapper.lrCollectionList(userId, type);
        if (lrCollectionList.size() != 0) {
            return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, lrCollectionList);
        } else {
            return Result.error(200, ResultStateInfo.SELECT_FAIL);
        }
    }

    /**
     * 取消收藏
     *
     * @param userId
     * @param contentId
     * @return
     */
    public Result deleteMyCollection(String userId, String contentId) {
        int code = userMapper.deleteMyCollection(userId, contentId);
        if (code == 0) {
            return Result.error(200, ResultStateInfo.DELETE_FAIL);
        } else {
            return Result.ok(100, ResultStateInfo.DELTE_SUCCESS);
        }
    }
}
