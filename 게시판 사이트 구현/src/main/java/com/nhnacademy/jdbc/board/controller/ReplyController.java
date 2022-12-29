package com.nhnacademy.jdbc.board.controller;


import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.reply.domain.ReplyRequest;
import com.nhnacademy.jdbc.board.reply.mapper.ReplyMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyMapper replyMapper;
    private final PostMapper postMapper;

    public ReplyController(ReplyMapper replyMapper, PostMapper postMapper) {
        this.replyMapper = replyMapper;
        this.postMapper = postMapper;
    }

    @GetMapping("/register")
    public String replyRegister(@ModelAttribute Reply reply
            , @ModelAttribute ReplyRequest replyRegisterRequest,
                                HttpServletRequest req) {
        HttpSession session = req.getSession();
        String writer = (String) session.getAttribute("userLogin");
        replyMapper.insertReply(new Reply(reply.getReplyId(), replyRegisterRequest.getPostId(), writer, replyRegisterRequest.getContent(), new Date()));
        postMapper.updateReplyCount(reply.getPostId(), 1);
        return "redirect:/post/" + reply.getPostId() + "?user==" + writer;
    }

    @GetMapping("/{postId}/{replyId}/update")
    public String replyUpdateForm(@ModelAttribute Reply reply, ModelMap modelMap) {
        modelMap.put("replyId", reply.getReplyId());
        modelMap.put("postId", reply.getPostId());

        return "thymeleaf/replyUpdate";
    }

    @PostMapping("/{postId}/{replyId}/update")
    public String replyUpdate(@ModelAttribute Reply reply
            , @ModelAttribute ReplyRequest replyRegisterRequest,
                              HttpServletRequest req) {
        HttpSession session = req.getSession();
        String writer = (String) session.getAttribute("userLogin");
        replyMapper.updateReplyById(new Reply(reply.getReplyId(), reply.getPostId(), writer, replyRegisterRequest.getContent(), new Date()));
        return "redirect:/post/" + reply.getPostId();
    }

    @GetMapping("/{postId}/{replyId}/delete")
    public String replyDeleteForm(@ModelAttribute Reply reply,
                                  HttpServletRequest req) {
        HttpSession session = req.getSession();
        String writer = (String) session.getAttribute("userLogin");
        replyMapper.deleteReplyById(new Reply(reply.getReplyId(), reply.getPostId(), writer, reply.getContent(), new Date()));
        postMapper.updateReplyCount(reply.getPostId(), -1);
        return "redirect:/post/" + reply.getPostId();
    }
}
