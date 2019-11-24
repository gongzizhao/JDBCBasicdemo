package com.jdbcTemplate;

import com.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author rosiezhao
 * @date 2019/11/23 20:42
 */
public class Demo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update study set class=2 where id=?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
