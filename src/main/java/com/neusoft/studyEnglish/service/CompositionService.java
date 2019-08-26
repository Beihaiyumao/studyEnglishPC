package com.neusoft.studyEnglish.service;

import com.neusoft.studyEnglish.dao.CompositionMapper;
import com.neusoft.studyEnglish.entity.Collections;
import com.neusoft.studyEnglish.entity.Composition;
import com.neusoft.studyEnglish.entity.ExamQuestion;
import com.neusoft.studyEnglish.tool.Result;
import com.neusoft.studyEnglish.tool.ResultStateInfo;
import com.neusoft.studyEnglish.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompositionService {
    @Autowired
    private CompositionMapper compositionMapper;

    /**
     * 所有作文
     *
     * @param type
     * @return
     */
    public Result allComposition(String type, String zfType) {
        List<Composition> all = compositionMapper.all(type, zfType);
        return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, all);
    }

    /**
     * 收藏作文
     *
     * @param userId
     * @param compositionId
     * @return
     */
    public Result collection(String userId, String compositionId, int type) {
        Collections collection = new Collections();
        collection.setCollectionId(SystemTool.uuid());
        collection.setCollectionType(type);
        collection.setCreateTime(SystemTool.getDateTime());
        collection.setUserId(userId);
        collection.setContentId(compositionId);
        int code = compositionMapper.collectionComposition(collection);
        if (code == 1) {
            return Result.ok(100, ResultStateInfo.SUCCESS);
        } else {
            return Result.error(200, ResultStateInfo.FAIL);
        }
    }

    /**
     * 所有试题包括听力和阅读理解
     *
     * @param examType
     * @param gradeType
     * @return
     */
    public Result allExamQuestion(String examType, String gradeType) {
        List<ExamQuestion> allExamQuestionList = compositionMapper.allExamQuestion(examType, gradeType);
        return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, allExamQuestionList);
    }

    /**
     * 根据id获取翻译和写作内容
     *
     * @param comId
     * @return
     */
    public Result selectComById(String comId, String userId) {
        Collections zfCollectionState = compositionMapper.zfCollectionState(userId,comId,0);
        Composition composition = compositionMapper.selectComById(comId);
        if (composition == null) {
            return Result.error(200, ResultStateInfo.SELECT_FAIL);
        } else {
            //查询改用户是否收藏了
            if (zfCollectionState != null) {
                composition.setCollectionState(true);
            } else {
                composition.setCollectionState(false);
            }
            return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, composition);
        }
    }
}
