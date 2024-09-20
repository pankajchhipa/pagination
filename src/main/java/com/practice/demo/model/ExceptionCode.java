package com.practice.demo.model;

import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionCode {
    public String errorCode;
    public String message;
    public String stackTrace;
}
