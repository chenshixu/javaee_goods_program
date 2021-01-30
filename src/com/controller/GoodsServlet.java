package com.controller;

import com.model.Goods;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GoodsServlet extends HttpServlet {
    private GoodsService goodsService;
    public GoodsServlet() {
        goodsService=new GoodsServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //新增或修该
        //处理乱码
//        resp.setCharacterEncoding("utf-8");
//        req.setCharacterEncoding("utf-8");
        //执行新增或修该
        String modify=req.getParameter("modify");
        String gid=req.getParameter("gid");
        String gname = req.getParameter("gname");
        String price=req.getParameter("price");
        Goods goods=new Goods(Integer.parseInt(gid),gname,Double.parseDouble(price));
        if(modify.equals("1")){
            //修改操作
            goodsService.update(goods);
        }
        else if(modify.equals("0")) {
            //新增
            goodsService.save(goods);
        }
        resp.sendRedirect("goods?cmd=list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看列表或删除

        String cmd = req.getParameter("cmd");
        if("list".equals(cmd)){
            List<Goods> list =  goodsService.list();
            req.setAttribute("list",list);
            //跳转
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        }
        else if("del".equals(cmd)){
            String gid = req.getParameter("gid");
            goodsService.delete(new Goods(Integer.parseInt(gid),null,0.0));
           //重定向
            resp.sendRedirect("goods?cmd=list");
        }
    }

    @Override
    public void destroy() {
        goodsService.close();
    }
}
