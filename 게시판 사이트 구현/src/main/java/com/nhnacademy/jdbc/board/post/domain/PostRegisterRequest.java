package com.nhnacademy.jdbc.board.post.domain;


import org.hibernate.validator.constraints.Length;

public class PostRegisterRequest {
    private Long id;
    @Length(min = 0, max = 200)
    private String title;
    @Length(min = 0, max = 40000)
    private String content;
    private String writerId;
    private String postTime;
    private int replyCount;

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

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public PostRegisterRequest() {
    }

}

