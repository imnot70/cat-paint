package org.cat.paint.controller;


import org.cat.paint.beans.vo.Result;
import org.cat.paint.enums.RespCode;

public class BaseController {

    protected <T> Result<T> success(T data){
        Result<T> result = new Result<>(RespCode.OK);
        result.setData(data);
        return result;
    }

    protected <T> Result<T> failed(RespCode code){
        return new Result<>(code);
    }

    protected <T> Result<T> failed(RespCode code,String msg){
        Result<T> result = new Result<>(code);
        result.setMsg(msg);
        return result;
    }
}
