package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ControllerTest {
    @Autowired
    HomeController homeController;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private PostMapper postMapper;


    @Test
    void homeForm() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk());

    }
}