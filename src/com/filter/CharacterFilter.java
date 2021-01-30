package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//注解代替配置
@WebFilter("/*")
public class CharacterFilter implements Filter {
    public CharacterFilter() {
        System.out.println("CharaterFilter实例化");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharaterFilter-init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter()");

        //统一设置字符集
        //从前端到后端
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        //从后端到前端
        servletResponse.setContentType("text/html;charset=utf-8");

        //正常放行
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("CharaterFilter-destroy()");

    }
}
