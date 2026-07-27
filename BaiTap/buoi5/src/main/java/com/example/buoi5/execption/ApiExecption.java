package com.example.buoi5.execption;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiExecption extends RuntimeException{

    private String ma;

    public ApiExecption(String message, String ma) {
        super(message);
        this.ma = ma;
    }
}
