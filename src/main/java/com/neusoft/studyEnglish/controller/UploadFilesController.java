package com.neusoft.studyEnglish.controller;


import com.neusoft.studyEnglish.service.UploadFilesService;
import com.neusoft.studyEnglish.tool.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 文件上传服务器
 *
 */
@RestController
@RequestMapping("/uploadFiles")
public class UploadFilesController {
    @Autowired
    private UploadFilesService uploadFilesService;


    /**
     * 修改用户头像
     *
     * @param file
     * @return
     */
    @PostMapping("/changUserPho")
    public Result changUserPho(@RequestParam("file") MultipartFile file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
        // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + "img/" + "headPhoto/" + time + "/";
        return uploadFilesService.uploadPic(file, path);
    }

    /**
     * 上传听力
     * @param file
     * @return
     */
    @PostMapping("/uploadMp3")
    public Result uploadMp3(@RequestParam("file") MultipartFile file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + "mp3/" + time + "/";
        return uploadFilesService.uploadMp3(file, path);
    }


}
