package com.test.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/3 7:17 下午
 * @Email: yongye.ysf@raycloud.com
 */
public class AuthorizedRequestFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext() ; // 获取当前请求的上下文
        if(currentContext.getRequest().getRequestURI().contains("/user-proxy")) {
            String auth = "admin:enjoy"; // 认证的原始信息
            byte[] encodedAuth = Base64.getEncoder()
                    .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
            String authHeader = "Basic " + new String(encodedAuth);
            currentContext.addZuulRequestHeader("Authorization", authHeader);
        } else if(currentContext.getRequest().getRequestURI().contains("/client-proxy")) {
            String auth = "admin:enjoy1"; // 认证的原始信息
            byte[] encodedAuth = Base64.getEncoder()
                    .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
            String authHeader = "Basic " + new String(encodedAuth);
            currentContext.addZuulRequestHeader("Authorization", authHeader);
        }

        return null;
    }
}
