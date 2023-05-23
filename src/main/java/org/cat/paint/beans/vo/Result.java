package org.cat.paint.beans.vo;

import lombok.Data;
import org.cat.paint.enums.RespCode;

@Data
public class Result<T> {

    private String code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(RespCode code){
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
