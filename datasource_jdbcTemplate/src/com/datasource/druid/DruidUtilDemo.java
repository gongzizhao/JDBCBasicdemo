package com.datasource.druid;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author rosiezhao
 * @date 2019/11/23 19:53
 */
public class DruidUtilDemo {
    public static void main(String[] args) {
        /*
        * 完成添加操作
        * */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义Sql
            String sql = "insert into study(id,username,class,sex) values(null,?,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setString(1,"wangwu");
            pstmt.setInt(2,4);
            pstmt.setString(3, "男");
            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            JDBCUtils.close(pstmt,conn);
        }

    }
}
