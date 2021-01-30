package com.model;

public class Goods {
    private int gid;
    private String gname;
    private double price;
    public Goods(){

    }
    public Goods(int gid,String gname,double price){
        this.gid=gid;
        this.gname=gname;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                '}';
    }
}
