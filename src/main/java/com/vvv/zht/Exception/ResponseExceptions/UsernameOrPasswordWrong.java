package com.vvv.zht.Exception.ResponseExceptions;

import com.vvv.zht.Exception.BaseException;
import com.vvv.zht.enums.ResponseCodeMsgEnum;

public class UsernameOrPasswordWrong extends BaseException {
    public UsernameOrPasswordWrong(String detail) {
        super(ResponseCodeMsgEnum.USERNAME_OR_PASSWORD_WRONG, detail);
    }
}
