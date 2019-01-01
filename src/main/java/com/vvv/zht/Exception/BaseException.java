package com.vvv.zht.Exception;

import com.vvv.zht.common.ResponseCodeMsg;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 2804019021764736252L;

    private ResponseCodeMsg responseCodeMsg;

    protected BaseException(ResponseCodeMsg responseCodeMsg, String detail) {
        super(detail, (Throwable)null, true, responseCodeMsg.getHttpStatus().is5xxServerError());
        this.responseCodeMsg = responseCodeMsg;
    }

    public ResponseCodeMsg getResponseCodeMsg() {
        return this.responseCodeMsg;
    }
}
