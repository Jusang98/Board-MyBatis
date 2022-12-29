package com.nhnacademy.jdbc.board.post.domain;


import java.util.Date;

public class Post {
    private Long id;
    private String title;
    private String content;
    private String userId;
    private Date postTime;
    private int replyCount;

    public Post(Long id, String title, String content, int replyCount, String userId, Date postTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.postTime = postTime;
        this.replyCount = replyCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }


}
