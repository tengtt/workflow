package org.seckill.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teng on 2016/5/19.
 */
public class TestInterceptor implements HandlerInterceptor{


    //是否将当前请求拦截下来，如果返回false，请求将被终止
    //Object handler：被拦截的请求的目标对象
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行到了preHandle--1");
        request.setCharacterEncoding("utf-8");

        if(request.getSession().getAttribute("user") == null){
            //终止请求
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return false;
        }
        return true;
    }
    /*
    modelAndView可以改变请求的目标视图
    *
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       /* modelAndView.addObject("msg","postHandle处理之后的视图");
        modelAndView.setViewName("hello2.jsp");*/
        System.out.println("执行到了postHandle--1");
    }

    /*
    * 视图渲染之后执行的方法
    * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行到了afterCompletion--1");
    }
}
