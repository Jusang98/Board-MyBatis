package com.nhnacademy.jdbc.board.reply.domain;

import java.util.Date;

public class Reply {
    private Long replyId;
    private Long postId;
    private String writer;
    private String content;
    private Date replyTime;

    public Reply(Long replyId, Long postId, String writer, String content, Date replyDate) {
        this.replyId = replyId;
        this.postId = postId;
        this.writer = writer;
        this.content = content;
        this.replyTime = replyDate;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}
