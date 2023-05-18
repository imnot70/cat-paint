package org.cat.paint.beans.vo;

import lombok.Data;

@Data
public class Result<T> {

    public Result() {
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private String code;
    private String msg;
    private T data;

}
