package com.service;

import com.dao.GoodsDao;
import com.dao.GoodsDaoImpl;
import com.model.Goods;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public List<Goods> list() {
        try {
            return  goodsDao.list();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Goods getGoodsByGid(int gid) {
        return goodsDao.getGoodsByGid(gid);
    }

    @Override
    public boolean save(Goods goods)  {
        return goodsDao.save(goods);
    }

    @Override
    public boolean update(Goods goods) {
        return goodsDao.update(goods);
    }

    @Override
    public boolean delete(Goods goods) {
        return goodsDao.delete(goods);
    }

    @Override
    public void close(){
        goodsDao.close();
    }
}
