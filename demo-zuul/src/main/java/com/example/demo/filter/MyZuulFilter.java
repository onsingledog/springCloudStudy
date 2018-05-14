package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/5/7.
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    Logger logger = Logger.getLogger(getClass());


    @Override
    public String filterType() {
        return "pre";
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
    public Object run() {

        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        logger.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL()));

        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
            logger.warn("token is empty");
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);
            try {
                rc.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        logger.info("OK");
        return null;
    }
}
