package com.yuzhe.travel.service;

import com.yuzhe.travel.domain.PageBean;
import com.yuzhe.travel.domain.Route;
import com.yuzhe.travel.domain.RouteImg;
import com.yuzhe.travel.domain.Seller;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 21:53
 */
public interface RouteService {

    /**
     * find the records for each category of currPage ;
     * @param cid
     * @param currPage
     * @param pageSize
     * @param rname
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currPage, int pageSize, String rname);

    /**
     * find a route's detail information base on rid
     * @param rid
     * @return
     */
    public Route findOneByRid(int rid);

}
