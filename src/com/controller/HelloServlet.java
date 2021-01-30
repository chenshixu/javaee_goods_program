package com.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//hello -> hello.jsp
//注解来代替配置,注解目的，约束和配置 @Override 必须重写
//@WebServlet(urlPatterns ={"/hello","/hi"},loadOnStartup = 1)
//@WebServlet(value = {"hello","hi"},loadOnStartup = 1)
//@WebServlet(value = "/h1")
//@WebServlet("/hi")
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public HelloServlet(){
        System.out.println("HelloServlet构造器实例化");
        //默认在第一次发送请求时才实例化，并且是单例模式(只会实例化一次的情况)
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("HelloServlet初始化");
        //一个生命周期里只执行一次
    }

    //重写post请求响应
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        //一个生命周期会执行多次
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("HelloServlet-service()方法");
        //一个生命周期会执行多次   每次访问都会调用
    }


    @Override
    public void destroy() {
        //一个生命周期只执行一次   在web容器tomcat停止的时候调用
        super.destroy();
        //部分重写
        System.out.println("HelloServlet销毁了");
    }

    //实习最基本的请求处理 get 请求
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        request.setAttribute("ename","吴彦祖");
        //响应跳转地址
//        request.getRequestDispatcher("hello.jsp").forward(request,response);//转发
        //response.sendRedirect("hello.jsp");//重定向

        //响应文本 PrintWriter使用就可以响应文本
//        response.setContentType("text/html;charset=UTF-8");//响应中文文本，防止乱码
        PrintWriter out=response.getWriter();
        out.println("螺丝Rose");
    }

}
