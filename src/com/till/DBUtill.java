package com.till;
import java.sql.*;

public class DBUtill {
    private Connection con=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
//    private static String url="jdbc:mysql://localhost:3306/";
//    private static String user="root";
//    private static String password="123456";
    //创立连接
    public DBUtill() {
        try {
            //加载驱动
            String driver=ConfigManager.getInstance().getString("driver");
            String url=ConfigManager.getInstance().getString("url");
            String username=ConfigManager.getInstance().getString("username");
            String password=ConfigManager.getInstance().getString("password");
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //查询
    public ResultSet executeQuery(String sql, Object obs[]) {
        try {
            ps=con.prepareStatement(sql);
            if(obs!=null){
                for(int i=0;i<obs.length;i++)
                    ps.setObject(i+1,obs[i]);
            }
            rs=ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //增删改
    public boolean execute(String sql,Object obs[]) {
        try {
            ps=con.prepareStatement(sql);
            if(obs!=null){
                for(int i=0;i<obs.length;i++){
                    ps.setObject(i+1,obs[i]);
                }
            }
            return  ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //释放资源
    public void closeAll() {
        try {
            if(rs!=null)rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
