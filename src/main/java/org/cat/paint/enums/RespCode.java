package org.cat.paint.enums;

public enum RespCode {
    OK("0000","ok"),
    FAILED("1000","failed"),
    SYSTEM_ERR("1001","system error");

    private final String code;
    private final String msg;

    RespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
