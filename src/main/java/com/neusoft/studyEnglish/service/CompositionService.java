package com.neusoft.studyEnglish.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.studyEnglish.dao.CompositionMapper;
import com.neusoft.studyEnglish.entity.*;
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
        if (all.size() == 0) {
            return Result.error(200, ResultStateInfo.SELECT_FAIL);
        } else {
            return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, all);
        }
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
        if (allExamQuestionList.size() == 0) {
            return Result.error(200, ResultStateInfo.SELECT_FAIL);
        } else {
            return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, allExamQuestionList);
        }
    }

    /**
     * 根据id获取翻译和写作内容
     *
     * @param comId
     * @return
     */
    public Result selectComById(String comId, String userId) {
        Collections zfCollectionState = compositionMapper.zfCollectionState(userId, comId, 0);
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

    /**
     * 查询听力和阅读理解题干
     *
     * @param exQuId
     * @return
     */
    public Page<Question> examQuestion(Integer pageNum, Integer pageSize, String exQuId) {

        //问题列表
        PageHelper.startPage(pageNum, pageSize);
        Page<Question> questionListPage = compositionMapper.questionListPage(exQuId);
        for (Question question : questionListPage) {
            //根据问题列表查询选项信息
            List<Option> optionList = compositionMapper.optionList(question.getQuestionId());
            question.setOptionList(optionList);
        }
        return questionListPage;
    }

    /**
     * 查询题干
     *
     * @param exQuId
     * @param userId
     * @return
     */
    public Result selectExamQuestionTG(String exQuId, String userId) {
        Collections collections = compositionMapper.lrCollectionState(userId, exQuId, 1);
        //查询题干
        ExamQuestion examQuestion = compositionMapper.examQuestions(exQuId);
        //判断是否已经收藏了
        if (collections != null) {
            examQuestion.setCollectionState(true);
        } else {
            examQuestion.setCollectionState(false);
        }
        return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, examQuestion);
    }

    /**
     * 查询正确答案
     *
     * @param exQuId
     * @return
     */
    public Result trueAnswer(String exQuId) {
        List<TrueAnswer> trueAnswers=compositionMapper.trueAnswer(exQuId);
        if(trueAnswers.size()==0){
            return Result.error(200,ResultStateInfo.SELECT_FAIL);
        }else {
            return Result.ok(100, ResultStateInfo.SELECT_SUCCESS,trueAnswers );
        }
    }
}
