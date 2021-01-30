package com.dao;
import com.model.Goods;
import com.service.GoodsServiceImpl;
import com.till.DBUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private DBUtill dbUtill;
    public  GoodsDaoImpl(){
        dbUtill=new DBUtill();
    }
    @Override
    public List<Goods> list() throws SQLException {
        List<Goods> list=new ArrayList<Goods>();
        ResultSet rs=dbUtill.executeQuery("select * from goods",null);
        int i=0;
        while(rs.next()){
            Goods goods=new Goods(rs.getInt(1),rs.getString(2),rs.getDouble(3));
            list.add(goods);
        }
        return list;
    }

    @Override
    public Goods getGoodsByGid(int gid) {
        String sql="select * from goods where gid=?";
        Object obj[]={gid};
        Goods goods=null;
        dbUtill=new DBUtill();
        try {
            ResultSet rs=dbUtill.executeQuery(sql,obj);
            while(rs.next()){
                goods=new Goods(gid,rs.getString("gname"),rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public boolean save(Goods goods)  {
        String sql="insert into goods (gid,gname,price) values(?,?,?)";
        Object obj[]={goods.getGid(),goods.getGname(),goods.getPrice()};
        dbUtill=new DBUtill();
        boolean  flag=dbUtill.execute(sql,obj);
        return flag;
    }

    @Override
    public boolean update(Goods goods) {
        String sql="update goods set gname=?,price=? where gid=?";
        Object obj[]={goods.getGname(),goods.getPrice(),goods.getGid()};
        dbUtill=new DBUtill();
        boolean flag=dbUtill.execute(sql,obj);
        return flag;
    }

    @Override
    public boolean delete(Goods goods) {
       String sql="delete  from goods where gid=?";
       Object obj[]={goods.getGid()};
       dbUtill=new DBUtill();
       boolean flag=dbUtill.execute(sql,obj);
       return flag;
    }

    @Override
    public void close() {
        dbUtill.closeAll();
    }
}
