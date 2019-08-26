package com.neusoft.studyEnglish.controller;

import com.neusoft.studyEnglish.dao.UserMapper;
import com.neusoft.studyEnglish.entity.User;
import com.neusoft.studyEnglish.service.UserService;
import com.neusoft.studyEnglish.tool.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param regist
     * @return
     */
    @PostMapping("/regist")
    public Result regist(@RequestBody User regist) {
        return userService.registNewUser(regist);
    }

    /**
     * 用户登陆
     *
     * @param login
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User login) {
        return userService.login(login);
    }

    /**
     * 更新密码
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @GetMapping("/updatePassword")
    public Result updatePassword(@RequestParam("userId") String userId, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
        return userService.updatePassword(userId, newPassword, oldPassword);
    }

    /**
     * 永久注销账户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public Result deleteUser(@RequestParam("userId") String userId) {
        return userService.deleteUser(userId);
    }

    /**
     * 修改昵称
     *
     * @param userId
     * @param username
     * @return
     */
    @GetMapping("/updateUsername")
    public Result updateUsername(@RequestParam("userId") String userId, @RequestParam("username") String username) {
        return userService.updateUsername(userId, username);
    }
    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/selectUserInfo", method = RequestMethod.GET)
    public Result selectUserInfo(@RequestParam("userId") String userId) {
        User userInfo = userService.selectUserInfoByUserId(userId);
        return new Result(100, "成功",  userInfo);
    }
    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public Result updateUserInfo(@RequestBody User user) {

        return userService.updateUserInfo(user);
    }
    /**
     * 更新头像
     *
     * @param fileName
     * @param userId
     * @return
     */
    @GetMapping("/updateHeadPhoto")
    public Result updateHeadPhoto(@RequestParam("fileName") String fileName, @RequestParam("userId") String userId) {
        return userService.updateHeadPhoto(fileName, userId);
    }
}
