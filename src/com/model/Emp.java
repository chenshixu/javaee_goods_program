package com.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Emp implements HttpSessionBindingListener {
    private int empno;
    private String ename;

    public Emp(String ename) {
        this.ename = ename;
    }
    public Emp() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        //存入session属性
        Count.ONLINE_NUM++;
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        //移除session作用域属性
        Count.ONLINE_NUM--;
    }
}
