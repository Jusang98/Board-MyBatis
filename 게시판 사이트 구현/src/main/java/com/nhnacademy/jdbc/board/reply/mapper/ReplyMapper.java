package com.nhnacademy.jdbc.board.reply.mapper;

import com.nhnacademy.jdbc.board.reply.domain.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<Reply> selectReplys(Long postId);

    int insertReply(Reply reply);

    int updateReplyById(Reply reply);

    int deleteReplyById(Reply reply);

}
