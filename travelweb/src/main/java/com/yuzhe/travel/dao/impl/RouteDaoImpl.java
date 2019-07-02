package com.yuzhe.travel.dao.impl;


import com.yuzhe.travel.dao.RouteDao;
import com.yuzhe.travel.domain.Route;
import com.yuzhe.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
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
    public int findTotalCount(int cid, String rname) {

        //create a template;
        String sql = "select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if(cid != 0){
            sb.append(" and cid = ? ");
            params.add(cid);
        }

        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }

        sql = sb.toString();
        return jdbcTemplate.queryForObject(sql, Integer.class, params.toArray());

    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        //String sql ="select * from tab_route where cid = ? limit ? , ?";

        String sql = " select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if(cid != 0){
            sb.append(" and cid = ? ");
            params.add(cid);
        }

        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(pageSize);
        sql = sb.toString();


        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());

    }

    @Override
    public Route findOneByRid(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
    }


}
