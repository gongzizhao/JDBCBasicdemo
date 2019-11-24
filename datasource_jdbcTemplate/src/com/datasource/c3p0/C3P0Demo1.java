package com.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author rosiezhao
 * @date 2019/11/22 17:01
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {

        //1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //2.获取连接对象
        for (int i=1;i<=10;i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+": "+conn);
        }
        //3.打印
    }
}
