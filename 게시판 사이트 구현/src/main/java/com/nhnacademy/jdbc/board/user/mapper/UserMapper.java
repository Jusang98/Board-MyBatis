package com.nhnacademy.jdbc.board.user.mapper;


import com.nhnacademy.jdbc.board.user.domain.User;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface UserMapper {
    User selectUser(String name);
}
