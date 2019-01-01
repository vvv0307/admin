package com.vvv.zht.Exception.ResponseExceptions;

import com.vvv.zht.Exception.BaseException;
import com.vvv.zht.enums.ResponseCodeMsgEnum;

public class ResponseNotOkExcetpion extends BaseException {
    public ResponseNotOkExcetpion(String detail) {
        super(ResponseCodeMsgEnum.MISSING_PARAMETER, detail);
    }
}
