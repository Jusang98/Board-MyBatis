package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.post.domain.Pagination;
import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final PostMapper postMapper;


    public HomeController(PostMapper postMapper) {
        this.postMapper = postMapper;

    }

    @GetMapping
    public String homeForm(@RequestParam(value = "page", defaultValue = "1") int page, HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("userLogin");
        model.addAttribute("user", user);
        Pagination pagination = new Pagination(postMapper.postCount(), page);
        model.addAttribute("postList", postMapper.selectPosts(pagination));
        model.addAttribute("page", page);
        model.addAttribute("pagination", pagination);
        return "thymeleaf/home";
    }
}
