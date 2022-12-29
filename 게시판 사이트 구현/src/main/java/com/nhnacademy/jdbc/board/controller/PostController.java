package com.nhnacademy.jdbc.board.controller;


import com.nhnacademy.jdbc.board.exception.PostNotFoundException;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.domain.PostRegisterRequest;
import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.reply.mapper.ReplyMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostMapper postMapper;
    private final ReplyMapper replyMapper;

    public PostController(PostMapper postMapper, ReplyMapper replyMapper) {
        this.postMapper = postMapper;
        this.replyMapper = replyMapper;
    }


    @ModelAttribute("post")
    public Post getPost(@PathVariable("postId") Long postId) {
        Post post = postMapper.selectPost(postId);
        if (Objects.isNull(post)) {
            throw new PostNotFoundException();
        }
        return post;
    }

    @GetMapping("/{postId}")
    public String viewPost(@ModelAttribute("post") Post post,
                           @ModelAttribute("reply") Reply reply, HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("userLogin");
        model.addAttribute("user", user);
        model.addAttribute("replyList", replyMapper.selectReplys(reply.getPostId()));

        model.addAttribute("post", post);
        return "thymeleaf/postView";
    }

    @GetMapping("/{postId}/modify")
    public String postModifyForm() {
        return "thymeleaf/postModify";
    }

    @PostMapping("/{postId}/modify")
    public String postmodify(@ModelAttribute Post post,
                             @ModelAttribute PostRegisterRequest postRegisterRequest,
                             HttpServletRequest req,
                             Model model) {
        int replyCount = 0;
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userLogin");
        postMapper.updatePostById(new Post(post.getId(), postRegisterRequest.getTitle(), postRegisterRequest.getContent(), replyCount, userId, new Date()));

        return "thymeleaf/postView";
    }

    @GetMapping("/{postId}/delete")
    public String postDeleteForm(@ModelAttribute Post post) {
        postMapper.deletePostById(post.getId());
        return "redirect:/home";
    }
}
