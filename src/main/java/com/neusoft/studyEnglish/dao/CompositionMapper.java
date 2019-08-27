package com.neusoft.studyEnglish.dao;


import com.neusoft.studyEnglish.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompositionMapper {
    int deleteByPrimaryKey(String compositionId);

    int insert(Composition record);

    int insertSelective(Composition record);

    int updateByPrimaryKeySelective(Composition record);

    int updateByPrimaryKey(Composition record);

    List<Composition> all(@Param("type") String type,@Param("zfType")String zfType);

    int collectionComposition(Collections collection);
    List<ExamQuestion>allExamQuestion(@Param("examType") String examType,@Param("gradeType") String gradeType);
    Composition selectComById(String compositionId);
    //作文和翻译的收藏状态
    Collections zfCollectionState(@Param("userId")String userId,@Param("comId")String comId,@Param("type")int type);
    ExamQuestion examQuestions(@Param("exQuId") String exQuId);
    List<Question> questionList1(@Param("exQuId") String exQuId);
    List<Option> optionList(@Param("questionId") String questionId);

}