package com.bigpao.com.model;

import java.util.Date;

/**
 * Created by hzdmm on 2017/3/1.
 */
public class Comment {
    private int commentId;
    private int courseId;
    private int stuId;
    private Date commentDate;
    private String commentString;

    public int getCommentId()  {
        return commentId;
    }

    public void setCommentId (int commentId) {
        this.commentId = commentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }
}
