package com.nhnacademy.jdbc.board.post.service;

import com.nhnacademy.jdbc.board.post.domain.Post;

public interface PostService {
    boolean exists(long id);

    Post register(String title, String content, String userId);

}
