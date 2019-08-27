package com.neusoft.studyEnglish.entity;


import java.util.List;

public class ExamQuestionVO {
    private ExamQuestion examQuestion;
    private List<Question> questionList;

    public ExamQuestion getExamQuestion() {
        return examQuestion;
    }

    public void setExamQuestion(ExamQuestion examQuestion) {
        this.examQuestion = examQuestion;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public ExamQuestionVO(ExamQuestion examQuestion, List<Question> questionList) {
        this.examQuestion = examQuestion;
        this.questionList = questionList;
    }
}
