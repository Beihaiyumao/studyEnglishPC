package com.neusoft.studyEnglish.entity;

import java.util.Date;

/**
 * 作文和翻译表
 */
public class Composition {
    private String compositionId;

    private String title;

    private String pic;

    private String introducer; //导语

    private Integer compositionType; //类型 0：四级1：六级

    private Date createTime;

    private String content; //内容

    private int zfType; //3:作文，2:翻译

    private boolean collectionState; //收藏装态

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(String compositionId) {
        this.compositionId = compositionId == null ? null : compositionId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer == null ? null : introducer.trim();
    }

    public Integer getCompositionType() {
        return compositionType;
    }

    public void setCompositionType(Integer compositionType) {
        this.compositionType = compositionType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getZfType() {
        return zfType;
    }

    public void setZfType(int zfType) {
        this.zfType = zfType;
    }

    public boolean isCollectionState() {
        return collectionState;
    }

    public void setCollectionState(boolean collectionState) {
        this.collectionState = collectionState;
    }
}