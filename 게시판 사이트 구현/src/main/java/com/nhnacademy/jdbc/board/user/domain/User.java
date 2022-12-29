package com.nhnacademy.jdbc.board.user.domain;

public class User {
    private final Long id;
    private final String name;
    private final String pwd;

    public User(Long id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return name;
    }
}
