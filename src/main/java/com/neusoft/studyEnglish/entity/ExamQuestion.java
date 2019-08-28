package com.neusoft.studyEnglish.entity;

/**
 * 试题试题【包括听力和阅读理解】
 */
public class ExamQuestion {
    private int compositionId;

    private String title;

    private String content; //内容

    private Integer examType; //试题类型 0翻译 1阅读理解

    private Integer gradeType; //试题所属等级 0 四级 1 六级

    private boolean  collectionState;

    public boolean isCollectionState() {
        return collectionState;
    }

    public void setCollectionState(boolean collectionState) {
        this.collectionState = collectionState;
    }

    public int getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(int compositionId) {
        this.compositionId = compositionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getExamType() {
        return examType;
    }

    public void setExamType(Integer examType) {
        this.examType = examType;
    }

    public Integer getGradeType() {
        return gradeType;
    }

    public void setGradeType(Integer gradeType) {
        this.gradeType = gradeType;
    }
}