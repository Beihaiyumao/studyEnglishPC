package com.neusoft.studyEnglish.service;

import com.neusoft.studyEnglish.tool.FileUtil;
import com.neusoft.studyEnglish.tool.Result;
import com.neusoft.studyEnglish.tool.ResultStateInfo;
import com.neusoft.studyEnglish.tool.SystemTool;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传服务器Service
 * 2019/1/21
 */
@Service
public class UploadFilesService {
    public Result uploadPic(MultipartFile file, String path) {
        if (!file.isEmpty()) {
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();
            //获取文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (suffix.equals("png") || suffix.equals("jpg")) {

                fileName = SystemTool.uuid() + "." + suffix;
            } else {
                return  Result.error(200, ResultStateInfo.PHOTO_TYPE, false);
            }
            File filePath = new File(path);
            //如果目录不存在则自动创建
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                // 该方法是对文件写入的封装，在tool类中，导入该包即可使用，后面会给出方法
                FileUtil.fileupload(file.getBytes(), path, fileName);
                return Result.ok(100, ResultStateInfo.UPLOAD_SUCCESS,fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return Result.error(200, ResultStateInfo.UPLOAD_FAIL, false);
            }
        }
        return Result.error(200, ResultStateInfo.NO_KNOW_FAIL, false);
    }

}
