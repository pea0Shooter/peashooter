package com.library.domain;

import lombok.Data;

@Data
public class Login {
    private String userName;
    private String passWord;
    private Integer permission;
}
