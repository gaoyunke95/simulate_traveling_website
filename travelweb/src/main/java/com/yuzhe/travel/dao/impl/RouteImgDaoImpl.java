package com.yuzhe.travel.dao.impl;

import com.yuzhe.travel.dao.RouteImgDao;
import com.yuzhe.travel.domain.RouteImg;
import com.yuzhe.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-07-01 - 19:34
 */
public class RouteImgDaoImpl implements RouteImgDao {
    private JdbcTemplate jdbcTemplate= new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<RouteImg> findImgByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
    }
}
