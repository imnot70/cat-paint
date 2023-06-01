package org.cat.paint.exception;

import org.cat.paint.enums.RespCode;

/**
 * @author zhangpeng
 * @description
 * @date 2023/6/1 10:49
 **/
public class BusinessException extends RuntimeException{

    private String code;

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(RespCode code){
        super(code.getMsg());
        this.code = code.getCode();
    }

    public String getCode() {
        return code;
    }

    public BusinessException setCode(String code) {
        this.code = code;
        return this;
    }

}
