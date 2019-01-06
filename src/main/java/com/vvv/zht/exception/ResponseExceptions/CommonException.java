package com.vvv.zht.exception.ResponseExceptions;

import com.vvv.zht.exception.BaseException;
import com.vvv.zht.common.ResponseCodeMsg;

public class CommonException extends BaseException {
    public CommonException(ResponseCodeMsg responseCodeMsg, String detail) {
        super(responseCodeMsg, detail);
    }
}