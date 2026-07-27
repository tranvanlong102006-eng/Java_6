package com.example.java6.buoi1.execption;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiExecption extends RuntimeException {

    private String code;

    public ApiExecption(String message, String code) {
        super(message);
        this.code = code;
    }
}
