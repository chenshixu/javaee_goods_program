package com.dao;

import com.model.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    //查询
    public List<Goods> list() throws SQLException;
    public Goods getGoodsByGid(int gid);

    //新增
    public boolean save(Goods goods) ;

    //修改
    public boolean update(Goods goods);
    //删除
    public boolean delete(Goods goods);

    //释放资源
    public void close();



}
