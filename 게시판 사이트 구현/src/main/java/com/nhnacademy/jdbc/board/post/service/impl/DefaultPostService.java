package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import com.nhnacademy.jdbc.board.post.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DefaultPostService implements PostService {
    private final PostMapper postMapper;


    public DefaultPostService(PostMapper postMapper) {
        this.postMapper = postMapper;

    }


    @Override
    public boolean exists(long id) {
        return Optional.of(postMapper.selectPost(id))
                .map(post -> post.getId().equals(id))
                .orElse(false);
    }

    @Override
    public Post register(String title, String content, String userId) {
        int replyCount = 0;
        long id = 0;
        return postMapper.selectPost(postMapper.insertPost(new Post(id, title, content, replyCount, userId, new Date())));
    }
}
