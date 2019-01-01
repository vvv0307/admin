package com.vvv.zht.common;

import org.springframework.http.HttpStatus;

public interface ResponseCodeMsg {
    int getCode();

    String getMessage();

    HttpStatus getHttpStatus();
}
