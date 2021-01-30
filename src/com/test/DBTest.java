package com.test;

import com.till.DBUtill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) throws SQLException {
        DBUtill dbt = new DBUtill();
        ResultSet rs = dbt.executeQuery("select * from person", null);

        while (rs.next()) {
            System.out.println(rs.getObject(2));
        }
        dbt.closeAll();
    }
}