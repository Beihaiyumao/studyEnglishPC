package com.neusoft.studyEnglish.entity;

/**
 * 正确答案
 */
public class TrueAnswer {
    private String questionTitle; //问题标题
    private String trueOption; //正确选项

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getTrueOption() {
        return trueOption;
    }

    public void setTrueOption(String trueOption) {
        this.trueOption = trueOption;
    }
}
