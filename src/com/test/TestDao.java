package com.test;

import com.dao.GoodsDao;
import com.dao.GoodsDaoImpl;
import com.model.Goods;

import java.sql.SQLException;
import java.util.List;

public class TestDao {
    public static void main(String[] args) throws SQLException {
        GoodsDao goodsDao=new GoodsDaoImpl();
        goodsDao.save(new Goods(4,"汪汪牛奶",2.5));
        List<Goods> list = goodsDao.list();
        for(Goods goods :list){
            System.out.println(goods);
        }
    }
}
