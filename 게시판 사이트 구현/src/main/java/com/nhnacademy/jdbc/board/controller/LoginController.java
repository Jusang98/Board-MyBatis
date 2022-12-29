package com.nhnacademy.jdbc.board.controller;


import com.nhnacademy.jdbc.board.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@Slf4j

public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.getAttribute("userLogin") != null) {
            session.setAttribute("id", session);
            return "redirect:/home";
        } else {
            return "thymeleaf/loginForm";
        }
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String name,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request
    ) {
        HttpSession session = request.getSession(true);
        if (userService.matches(name, pwd)) {
            session.setAttribute("userLogin", name);
            return "redirect:/home?user==" + name;
        } else {
            return "redirect:/login";
        }
    }


}
