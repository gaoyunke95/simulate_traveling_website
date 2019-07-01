package com.yuzhe.travel.dao.impl;

import com.yuzhe.travel.dao.CategoryDao;
import com.yuzhe.travel.domain.Category;
import com.yuzhe.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 16:36
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category";

        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));

    }
}
