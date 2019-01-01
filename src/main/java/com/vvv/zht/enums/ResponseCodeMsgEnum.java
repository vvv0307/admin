package com.vvv.zht.enums;

import com.vvv.zht.common.ResponseCodeMsg;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public enum ResponseCodeMsgEnum implements ResponseCodeMsg {
    MISSING_PARAMETER(1000, "缺少参数", BAD_REQUEST),
    USERNAME_OR_PASSWORD_WRONG(10001, "用户名或密码错误", BAD_REQUEST),
    STATUS_CHANGE_NOT_ALLOW(10002, "审核操作无效", BAD_REQUEST),
    INTERVAL_SHORT(10003, "操作频繁", BAD_REQUEST),
    INFO_NOT_EXIST(10004, "信息不存在", BAD_REQUEST);
    private int code;
    private String message;
    private HttpStatus httpStatus;  // response http status

    ResponseCodeMsgEnum(int value, String message, HttpStatus httpStatus) {
        this.code = value;
        this.message = message;
        this.httpStatus = httpStatus;
    }
    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
