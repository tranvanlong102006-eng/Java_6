package com.example.dethithu.execption;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExecptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerExecptionValidErro(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(s -> errorMap.put(
                s.getField(), s.getDefaultMessage()
        ));
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ApiExecption.class)
    public ResponseEntity<?> handlerApiExecption(ApiExecption e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "FAIL");
        errorMap.put("ma", e.getMa());
        errorMap.put("message", e.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerExecption(Exception e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "FAIL");
        errorMap.put("ma", "Loi logic");
        errorMap.put("message", e.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handlerDataInt(DataIntegrityViolationException e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "FAIL");
        errorMap.put("ma", "Loi logic");
        errorMap.put("message", "Ma da ton tai");
        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }
}
