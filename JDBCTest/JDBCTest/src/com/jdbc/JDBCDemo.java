package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {

    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包 1.1复制包到项目的libs目录内 1.2右键--add as library
        //2.注册驱动,mysql5之后的驱动jar包可以省略注册驱动的步骤
        //Class.forName("com.mysql.cj.jdbc.Driver");
        // 通过查看源码发现Driver中有static void registerDriver(new Driver())，即本质
        String url ="jdbc:mysql:///lesson?user=root&password=&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT" ;
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection(url);
        //4.定义sql语句
        String sql = "update study set class = 3 where id = 2";
        //5.获取执行sql的对象 statement
        Statement stmt = conn.createStatement();
        //6.执行sql executeUpdate的返回值是影响行数，从而判断DML语句是否执行成功
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();


    }
}
