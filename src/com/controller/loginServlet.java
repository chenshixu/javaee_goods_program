package com.controller;

import com.model.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //用户名必须包含admin，登录成功，用户信息存入session作用域 user-admin123
        String ename=req.getParameter("ename");
        if(ename.contains("admin")){
            //成功
            //获取session对象
            HttpSession session = req.getSession();
            session.setAttribute("user",new Emp(ename));//作用域中存用户对象
//            session.setMaxInactiveInterval(30);//设置30秒就失效

            resp.sendRedirect("goods?cmd=list");
        } else{
            //失败
            resp.sendRedirect("login.jsp");
        }
    }
}
