package com.test.user.handler;

import com.azul.crs.client.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/3 3:34 下午
 * @Email: yongye.ysf@raycloud.com
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public String exceptionHandler(HttpServletRequest request, Exception e){
        //全局异常处理逻辑
        return "全局异常拦截";

    }
}
