package com.scwen7.baseproject.common.exception;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class TokenException extends BaseException {
    public TokenException(String code, String displayMessage) {
        super(code, displayMessage);
    }
}
