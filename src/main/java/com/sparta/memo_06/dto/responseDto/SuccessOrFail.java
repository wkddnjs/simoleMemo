package com.sparta.memo_06.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class SuccessOrFail {

    private Boolean success;
    private Object data;
    private Error error;

    public static SuccessOrFail success(Object data) {
        return new SuccessOrFail(true,data,null);
    }

    public static SuccessOrFail fail(String code,String message) {
        return new SuccessOrFail(false,null,new Error(code,message));
    }



    @Getter
    @AllArgsConstructor
    static class Error {
        private String code;
        private String message;
    }

}
