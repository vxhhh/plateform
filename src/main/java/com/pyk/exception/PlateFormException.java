package com.pyk.exception;

import com.pyk.result.ResponseEnum;

public class PlateFormException extends RuntimeException {

    private ResponseEnum responseEnum;

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    public PlateFormException(ResponseEnum responseEnum){
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
    }
}
