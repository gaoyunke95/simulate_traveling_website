package com.yuzhe.travel.dao.impl;

import com.yuzhe.travel.dao.RouteDao;
import com.yuzhe.travel.domain.Route;
import com.yuzhe.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 22:00
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * base on the cid find out the total count of records;
     * @param cid
     * @return
     */
    @Override
    public int findTotalCount(int cid) {
        String sql = "select count(*) from tab_route where cid = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, cid);

    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize) {
        String sql ="select * from tab_route where cid = ? limit ? , ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Route>(Route.class), cid, start, pageSize);

    }
}
