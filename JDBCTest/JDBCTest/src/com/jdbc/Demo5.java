package com.jdbc;

import com.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author rosiezhao
 * @date 2019/11/22 10:29
 */
//1.通过键盘录入用户名和密码
//2.判断用户是否登录成功
public class Demo5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input name...");
        String username = sc.nextLine();
        System.out.println("input password...");
        String password = sc.nextLine();

        boolean flag = new Demo5().login(username, password);
        if (flag) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    public boolean login(String username, String password) {
        if (username == null||password==null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }


        return false;
    }

}
/**
 * PreparedStatement：
 *1.SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接，会造成安全性问题
 * 解决：使用PreparedStatement对象来解决
 * 预编译的sql！=静态sql
 * 参数使用占位符？：给？赋值
 *
 * 2.效率更高
*/
