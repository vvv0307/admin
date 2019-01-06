package com.vvv.zht.exception.ResponseExceptions;

import com.vvv.zht.exception.BaseException;
import com.vvv.zht.enums.ResponseCodeMsgEnum;

public class ResponseNotOkExcetpion extends BaseException {
    public ResponseNotOkExcetpion(String detail) {
        super(ResponseCodeMsgEnum.MISSING_PARAMETER, detail);
    }
}
