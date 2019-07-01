package com.yuzhe.travel.dao;

import com.yuzhe.travel.domain.Category;
import com.yuzhe.travel.domain.Route;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 21:50
 */
public interface RouteDao {

    /**
     * base on the cid find out the total count of records;
     * @param cid
     * @return
     */
    public int findTotalCount(int cid, String rname);

    /**
     * base on cid, and start, and pageSize to find out the currpage list collection of records;
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname);
}
