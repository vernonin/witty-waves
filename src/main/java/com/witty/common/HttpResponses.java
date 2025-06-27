package com.witty.common;

import lombok.Data;

/**
 * @author <a href="mailto:haunglin824@gmail.com">huanglin</a>
 * @param <T>
 */
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

    public static <T> HttpResponses<T> ok(String message, T data) {
        return new HttpResponses<T>(200, message, data);
    }

    public static HttpResponses ok(String message) {
        return new HttpResponses<>(200, message, null);
    }

    public static <T> HttpResponses<T> ok(T data) {
        return new HttpResponses<T>(200, "ok", data);
    }

    public static HttpResponses error(String message) {
        return new HttpResponses<>(500, message, null);
    }
}
