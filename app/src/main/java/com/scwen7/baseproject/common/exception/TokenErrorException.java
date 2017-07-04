package com.scwen7.baseproject.common.exception;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class TokenErrorException extends BaseException {
    public TokenErrorException(String code, String displayMessage) {
        super(code, displayMessage);
    }
}
