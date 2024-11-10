package com.witty.execption;

import com.witty.common.HttpResponses;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = BusinessException.class)
    public HttpResponses<Object> handleException(BusinessException ex, WebRequest request){
        System.out.println("自定义报错：" + ex.getMessage());
        return HttpResponses.error(ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public HttpResponses<Object> handleAllExceptions(Exception ex, WebRequest request){
        System.out.println("报错了：：：" + ex.getCause().getMessage());
        return HttpResponses.error(ex.getCause().getMessage());
    }
}
