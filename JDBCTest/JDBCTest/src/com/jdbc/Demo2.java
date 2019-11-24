package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
    public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "insert into study(username,class,sex) values('xiaosan',4,'男')";
            conn = DriverManager.getConnection("jdbc:mysql:///lesson?user=root&password=&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT");
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if (count > 0) {
                System.out.println("success");
            }else System.out.println("fail");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
