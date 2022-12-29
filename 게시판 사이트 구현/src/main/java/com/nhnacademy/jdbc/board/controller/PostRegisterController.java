package com.nhnacademy.jdbc.board.controller;


import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.domain.PostRegisterRequest;
import com.nhnacademy.jdbc.board.post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/register")
public class PostRegisterController {
    private final PostService postService;

    public PostRegisterController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String PostRegisterForm() {
        return "thymeleaf/postRegister";
    }

    @PostMapping
    public ModelAndView registerPost(@ModelAttribute PostRegisterRequest postRegisterRequest,
                                     HttpServletRequest req, Model model) throws IOException {
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userLogin");


        Post post = postService.register(postRegisterRequest.getTitle(),
                postRegisterRequest.getContent(), userId);


        ModelAndView mav = new ModelAndView("redirect:/home");

        mav.addObject("post", post);

        return mav;
    }
}
