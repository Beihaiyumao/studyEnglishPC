package com.neusoft.studyEnglish.entity;

import java.util.List;

/**
 * 问题题目实体
 */
public class Question {
    private String questionId;

    private String examQuestionId;

    private String content;

    private String trueOptionId;

    private List<Option> optionList;

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(String examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTrueOptionId() {
        return trueOptionId;
    }

    public void setTrueOptionId(String trueOptionId) {
        this.trueOptionId = trueOptionId == null ? null : trueOptionId.trim();
    }
}