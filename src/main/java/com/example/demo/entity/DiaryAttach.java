package com.example.demo.entity;

/**
 * @author XiongZiQi
 */
public class DiaryAttach {
    private int id;
    private String diaryId;
    private String attachUrl;
    private String attachName;
    private String operateTime;

    private String[] picBase64List;
    private String[] picNameList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String[] getPicBase64List() {
        return picBase64List;
    }

    public void setPicBase64List(String[] picBase64List) {
        this.picBase64List = picBase64List;
    }

    public String[] getPicNameList() {
        return picNameList;
    }

    public void setPicNameList(String[] picNameList) {
        this.picNameList = picNameList;
    }
}
