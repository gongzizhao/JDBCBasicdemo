package com.jdbcTemplate;

import com.domain.Emp;
import com.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author rosiezhao
 * @date 2019/11/24 9:59
 */
public class Demo2 {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //Junit单元测试，可以让方法独立执行，不依赖于主方法
    @Test
    public void test1() {
        String sql = "update study set class=3 where id=?";
        int count = template.update(sql,3);
        System.out.println(count);
    }

    @Test
    public void test2() {
        String sql = "select * from study where id=?";
        Map<String, Object> map = template.queryForMap(sql, 4);
        System.out.println(map);
    }

    @Test
    public void test3() {
        String sql = "select * from study";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }
    /*
     * 查询所有的记录，并将其封装成map
     * */
    @Test
    public void test4() {
        String sql = "select * from study";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String username = rs.getString("username");
                int classname = rs.getInt("class");
                String sex = rs.getString("sex");
                int time = rs.getInt("addtime");

                emp.setId(id);
                emp.setUsername(username);
                emp.setClassname(classname);
                emp.setSex(sex);
                emp.setAddtime(time);

                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);

        }
    }
    /*
    * 查询所有的记录，并将其封装成map
    * */
    @Test
    public void test4_1() {
        String sql = "select * from study";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);

        }
    }

    @Test
    public void test5() {
        String sql = "select count(*) from study";
        Integer i = template.queryForObject(sql, int.class);
        System.out.println(i);
    }
}
