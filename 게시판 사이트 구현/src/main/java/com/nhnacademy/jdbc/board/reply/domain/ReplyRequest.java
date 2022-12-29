package com.nhnacademy.jdbc.board.reply.domain;

import org.hibernate.validator.constraints.Length;



public class ReplyRequest {
    @Length(min = 0, max = 200)
    private String writer;
    @Length(min = 0, max = 500)
    private String content;

    private Long postId;

    public ReplyRequest(Long postId, String writer, String content) {
        this.postId = postId;
        this.writer = writer;
        this.content = content;
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
}
