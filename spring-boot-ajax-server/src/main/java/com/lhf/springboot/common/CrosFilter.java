package com.lhf.springboot.common;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: CrosFilter
 * @Description: 实现跨域
 * @Author: liuhefei
 * @Date: 2019/9/1
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    /*
    // 支持所有普通的跨域请求
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;

        res.addHeader("Access-Control-Allow-Origin", "*");  //允许所有的域跨域
        res.addHeader("Access-Control-Allow-Methods", "*");  //允许所有的方法跨域
        res.addHeader("Access-Control-Allow-Headers", "Content-Type");
        res.addHeader("Access-Control-Max-Age","3600");  //预检命令缓存，3600秒,告诉浏览器1个小时之内不要清除这段缓存信息。

        chain.doFilter(request, response);
    }*/


    /*
    //支持带cookie的单个域的跨域请求
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;

        res.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");  //单个域的带cookie的跨域
        res.addHeader("Access-Control-Allow-Credentials", "true");  //带cookie时需要设置该值
        res.addHeader("Access-Control-Allow-Methods", "*");  //允许所有的方法跨域
        res.addHeader("Access-Control-Allow-Headers", "Content-Type");
        res.addHeader("Access-Control-Max-Age","3600");  //预检命令缓存，3600秒,告诉浏览器1个小时之内不要清除这段缓存信息。

        chain.doFilter(request, response);
    }*/


     /*
    //支持带cookie的所有域的跨域请求
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;

        HttpServletResponse res = (HttpServletResponse) response;

        String origin = req.getHeader("Origin");

         if(!StringUtils.isEmpty(origin)){
            //带cookie的时候，origin必须是全匹配，不能使用*
            res.addHeader("Access-Control-Allow-Origin", origin);   //允许跨域
        }

        res.addHeader("Access-Control-Allow-Credentials", "true");  //带cookie时需要设置该值
        res.addHeader("Access-Control-Allow-Methods", "*");  //允许所有的方法跨域
        res.addHeader("Access-Control-Allow-Headers", "Content-Type");
        res.addHeader("Access-Control-Max-Age","3600");  //预检命令缓存，3600秒,告诉浏览器1个小时之内不要清除这段缓存信息。

        chain.doFilter(request, response);
    }*/

    /*
    //支持带cookie的所有域的跨域请求
    //自定义请求头的跨域
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;

        HttpServletResponse res = (HttpServletResponse) response;

        String origin = req.getHeader("Origin");

        if(!StringUtils.isEmpty(origin)){
            //带cookie的时候，origin必须是全匹配，不能使用*
            res.addHeader("Access-Control-Allow-Origin", origin);   //允许跨域
        }

        res.addHeader("Access-Control-Allow-Credentials", "true");  //带cookie时需要设置该值
        res.addHeader("Access-Control-Allow-Methods", "*");  //允许所有的方法跨域
        res.addHeader("Access-Control-Allow-Headers", "Content-Type,x-header1,x-header2");  //把请求头写死了，不推荐
        res.addHeader("Access-Control-Max-Age","3600");  //预检命令缓存，3600秒,告诉浏览器1个小时之内不要清除这段缓存信息。

        chain.doFilter(request, response);
    }*/


    //解决所有跨域
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse res = (HttpServletResponse) response;

        String origin = req.getHeader("Origin");

        //res.addHeader("Access-Control-Allow-Origin", "*");  //允许所有的域跨域
        //res.addHeader("Access-Control-Allow-Methods", "*");  //允许所有的方法跨域

        if(!StringUtils.isEmpty(origin)){
            //带cookie的时候，origin必须是全匹配，不能使用*
            res.addHeader("Access-Control-Allow-Origin", origin);   //允许跨域
        }

        res.addHeader("Access-Control-Allow-Methods", "*");  //允许跨域的方法

        String headers = req.getHeader("Access-Control-Request-Headers");

        //支持所有自定义头
        if(!StringUtils.isEmpty(headers)){
            res.addHeader("Access-Control-Allow-Headers", headers);
        }

        res.addHeader("Access-Control-Max-Age", "3600");

        //enable cookie
        res.addHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(request, response);

    }

    @Override
    public void destroy(){

    }
}
