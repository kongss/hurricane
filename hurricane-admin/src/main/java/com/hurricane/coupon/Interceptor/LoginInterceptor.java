package com.hurricane.coupon.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        /**
         * 对来自后台的请求统一进行日志处理
         */
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        System.out.println(request.getParameterMap());
        System.out.println(String.format("请求参数, url: %s, method: %s, uri: %s, params: %s", url, method, uri, queryString));

        HttpSession session = request.getSession();
        /*if (session.getAttribute("user") == null){
            System.out.println("登录地址-------------"+request.getContextPath()+"/admin/manage/login");
            //未登录状态,重定向登录页面
            response.sendRedirect(request.getContextPath()+"/admin/manage/login");
            return false;
        }*/

        return true;


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
