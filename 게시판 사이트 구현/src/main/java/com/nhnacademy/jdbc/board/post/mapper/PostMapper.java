package com.nhnacademy.jdbc.board.post.mapper;

import com.nhnacademy.jdbc.board.post.domain.Pagination;
import com.nhnacademy.jdbc.board.post.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    Post selectPost(long id);

    List<Post> selectPosts(Pagination pagination);

    int insertPost(Post post);

    int updatePostById(Post post);

    int deletePostById(Long id);

    void updateReplyCount(@Param("id") Long id, @Param("amount") int amount);

    int postCount();
}
