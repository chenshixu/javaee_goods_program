package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//配置    拦截所有请求
@WebFilter("/*")
public class LoginFilter implements Filter {
    //放行的地址的集合
    private static List<String> urls = new ArrayList<String>();

    //静态代码块，只实例化一次
    static {
        urls.add("login.jsp");
        urls.add("login");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //先获取当前请求地址
        System.out.println("doFilter-login");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();//项目名
        //StringBuffer requestURL = request.getRequestURL();//网页名
//        System.out.println(requestURI);//   /test_2war_exploded/hello
//        System.out.println(requestURL);//   http://localhost:8080/test2_war_exploded/hello
        for (String url : urls) {
            if (requestURI.contains(url)==true) {
                //放行
                filterChain.doFilter(servletRequest, servletResponse);
                return;//必须跳出，不然一直循环访问login.jsp
            }
        }
        //如果作用域中由user，说明已经登录，放行
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            filterChain.doFilter(servletRequest,servletResponse);//放行
        }else {
            //如果作用域中没有user，说明未登录,重定向到登录页
            HttpServletResponse response=(HttpServletResponse)servletResponse;
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
