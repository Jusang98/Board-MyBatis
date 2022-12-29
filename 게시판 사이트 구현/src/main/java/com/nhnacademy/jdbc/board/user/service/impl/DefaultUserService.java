package com.nhnacademy.jdbc.board.user.service.impl;


import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {
    private final UserMapper userMapper;

    public DefaultUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public boolean matches(String name, String pwd) {
        return Optional.of(userMapper.selectUser(name))
                .map(user -> user.getPwd().equals(pwd))
                .orElse(false);
    }
}
