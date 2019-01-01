package com.vvv.zht.Exception.ResponseExceptions;

import com.vvv.zht.Exception.BaseException;
import com.vvv.zht.common.ResponseCodeMsg;

public class CommonException extends BaseException {
    public CommonException(ResponseCodeMsg responseCodeMsg, String detail) {
        super(responseCodeMsg, detail);
    }
}