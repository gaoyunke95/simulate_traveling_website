package com.yuzhe.travel.dao.impl;

import com.yuzhe.travel.dao.SellerDao;
import com.yuzhe.travel.domain.Seller;
import com.yuzhe.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Henry Gao
 * @date 2019-07-01 - 19:34
 */
public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Seller findSellerBySid(int sid) {
        String sql = "select * from tab_seller where sid = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), sid);
    }
}
