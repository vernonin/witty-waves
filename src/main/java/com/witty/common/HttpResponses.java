package com.witty.common;

import lombok.Data;

@Data
public class HttpResponses<T> {
    private int code;
    private String message;
    private T data;

    public HttpResponses() {}
    public HttpResponses(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> HttpResponses<T> ok(T data) {
        return new HttpResponses<T>(200, "OK", data);
    }

    public static HttpResponses<Object> error(String message) {
        return new HttpResponses<>(500, message, null);
    }
}
