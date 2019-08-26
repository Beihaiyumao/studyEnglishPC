package com.neusoft.studyEnglish.controller;

import com.neusoft.studyEnglish.service.CompositionService;
import com.neusoft.studyEnglish.tool.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/composition")
public class CompositionController {
    @Autowired
    private CompositionService compositionService;

    /**
     * 所有作文和翻译
     *
     * @param type
     * @return
     */
    @GetMapping("/all")
    public Result all(String type, String zfType) {
        return compositionService.allComposition(type, zfType);
    }

    /**
     * 根据id获取翻译和写作内容
     *
     * @param comId
     * @return
     */
    @GetMapping("/selectComById")
    public Result selectComById(@RequestParam("comId")String comId,@RequestParam("userId") String userId) {
        return compositionService.selectComById(comId,userId);
    }

    /**
     * 收藏
     *
     * @param userId
     * @param compositionId
     * @return
     */
    @GetMapping("/collection")
    public Result collection(@RequestParam("userId") String userId, @RequestParam("compositionId") String compositionId,@RequestParam("type")int type) {
        return compositionService.collection(userId, compositionId,type);
    }

    /**
     * 所有听力和阅读理解
     *
     * @param examType
     * @param gradeType
     * @return
     */
    @GetMapping("/allExamQuestion")
    public Result allExamQuestion(String examType, String gradeType) {
        return compositionService.allExamQuestion(examType, gradeType);
    }
}
