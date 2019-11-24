package com.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author rosiezhao
 * @date 2019/11/22 9:40
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String serverTimezone;
    private static String driver;

    /**
     * 文件的读取，只需要读取1次即可拿到这些值，使用静态代码块
     * @return
    */
    static{
        //读取资源文件获取值
        try {
            //1.创建Properties集合类
            Properties pro = new Properties();
            //获取src路径下的文件的方式ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            //2.加载文件
            //pro.load(new FileReader("src/jdbc.properties"));
            pro.load(new FileReader(path));
            //3.获取属性，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            serverTimezone=pro.getProperty("serverTimezone");
            driver = pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取连接
     * @return 连接对象
    */
    //不想传递参数，还得保证工具类得通用性
    //用配置文件
    public static Connection getConnection() throws Exception {
        String str=url+"?user="+user+"&password="+password+"&serverTimezone="+serverTimezone;
        return DriverManager.getConnection(str);
    }

    /**
     * 释放资源
     * @return
    */
    public static void close(Statement stmt,Connection conn) {
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
    public static void close(ResultSet rs,Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
