package com.service;

import com.model.Goods;

import java.util.List;

public interface GoodsService {
    //查询
    public List<Goods> list() ;
    public Goods getGoodsByGid(int gid);

    public boolean save(Goods goods) ;
    //修改
    public boolean update(Goods goods);
    //删除
    public  boolean delete(Goods goods);

    public void  close();
}
