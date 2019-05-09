package com.hang.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
@Component
public class LoginFilter extends ZuulFilter {
   /*过滤器类型*/
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /*过滤器执行顺序，越小越先执行*/
    @Override
    public int filterOrder() {
        return 4;
    }

    /*过滤器是否生效,返回true表示拦截*/
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext =
                RequestContext.getCurrentContext();
        HttpServletRequest request =
                requestContext.getRequest();
        System.out.println(request.getRequestURI());
       if ("/apigateway/order/listall".equalsIgnoreCase(request.getRequestURI())){
           return true;
       } else if ("/apigateway/login".equalsIgnoreCase(request.getRequestURI())){
           return true;
       }
        return false;
    }

    /*逻辑开发*/
    @Override
    public Object run()  {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //token对象
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        if (StringUtils.isBlank(token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
