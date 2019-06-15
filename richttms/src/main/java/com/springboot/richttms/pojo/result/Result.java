package com.springboot.richttms.pojo.result;

import org.omg.PortableInterceptor.INACTIVE;

public class Result {
    private String result;
    private Integer code;

    public Result(String result, Integer code) {
        this.result = result;
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
