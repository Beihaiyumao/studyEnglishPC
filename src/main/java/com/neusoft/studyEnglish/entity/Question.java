package com.neusoft.studyEnglish.entity;

/**
 * 问题题目实体
 */
public class Question {
    private Integer questionId;

    private String examQuestionId;

    private String content;

    private String trueOptionId;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(String examQuestionId) {
        this.examQuestionId = examQuestionId == null ? null : examQuestionId.trim();
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