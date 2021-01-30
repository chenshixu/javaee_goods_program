package com.test;

import com.model.Goods;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestGoods {
    public static void main(String[] args) throws SQLException {
        System.out.println("***商品管理***");
        GoodsService goodsService=new GoodsServiceImpl();
        Scanner scan=new Scanner(System.in);
        int menu;
        int gid;
        String gname;
        double price;
        do{
            System.out.println("1.查看列表 2.新增 3.修改 4.删除 5退出");
            menu=scan.nextInt();
            switch (menu){
                case 1:
                    List<Goods> list = goodsService.list();
                    for(Goods goods:list){
                        System.out.println(goods.toString());
                    }
                    break;
                case 2:
                    System.out.println("输入编号:");
                    gid=scan.nextInt();
                    System.out.println("输入名称:");
                    gname=scan.next();
                    System.out.println("输入价格");
                    price=scan.nextDouble();
                    Goods goods=new Goods(gid,gname,price);
                    goodsService.save(goods);
                    break;
                case 3:
                    System.out.println("请输入修改编号:");
                    gid=scan.nextInt();
                    List<Goods> list1 = goodsService.list();
                    boolean flag=false;
                    for(Goods goods1:list1){
                       if(goods1.getGid()==gid){
                           flag=true;
                           break;
                       }
                    }
                    System.out.println("输入名称:");
                    gname=scan.next();
                    System.out.println("输入价格");
                    price=scan.nextDouble();
                   new Goods(gid,gname,price);
                    goodsService.update(new Goods(gid,gname,price));
                    break;
                case 4:
                    System.out.println("请输入删除编号:");
                    gid=scan.nextInt();
                    goodsService.delete(new Goods(gid,"",0));
                    break;
                default:
                    break;
            }
        }while(menu!=5);

    }


}
