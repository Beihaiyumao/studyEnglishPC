package com.neusoft.studyEnglish.controller;

import com.github.pagehelper.Page;
import com.neusoft.studyEnglish.entity.Question;
import com.neusoft.studyEnglish.service.CompositionService;
import com.neusoft.studyEnglish.tool.PageInfo;
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
    public Result selectComById(@RequestParam("comId") String comId, @RequestParam("userId") String userId) {
        return compositionService.selectComById(comId, userId);
    }

    /**
     * 收藏
     *
     * @param userId
     * @param compositionId
     * @return
     */
    @GetMapping("/collection")
    public Result collection(@RequestParam("userId") String userId, @RequestParam("compositionId") String compositionId, @RequestParam("type") int type) {
        return compositionService.collection(userId, compositionId, type);
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

    /**
     * 查看查看详情听力和阅读问题
     *
     * @param exQuId
     * @return
     */
    @GetMapping("/examQuestion")
    public PageInfo<Question> examQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                           @RequestParam(defaultValue = "1", value = "pageSize") Integer pageSize,
                                           @RequestParam("exQuId") String exQuId) {
        Page<Question> allExamQuestion = compositionService.examQuestion(pageNum, pageSize, exQuId);
        PageInfo<Question> pageInfo = new PageInfo<>(allExamQuestion);
        return pageInfo;
    }

    /**
     * 查看查看详情听力和阅读题干
     *
     * @param exQuId
     * @param userId
     * @return
     */
    @GetMapping("/examQuestionTG")
    public Result examQuestionTG(@RequestParam("exQuId") String exQuId, @RequestParam("userId") String userId) {
        return compositionService.selectExamQuestionTG(exQuId, userId);
    }

    /**
     * 查询正确结果集
     *
     * @param exQuId
     * @return
     */
    @GetMapping("/getExamQuesitonAnswer")
    public Result getExamQuesitonAnswer(@RequestParam("exQuId") String exQuId) {
        return compositionService.trueAnswer(exQuId);
    }
}
