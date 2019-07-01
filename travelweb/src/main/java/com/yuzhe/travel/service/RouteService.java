package com.yuzhe.travel.service;

import com.yuzhe.travel.domain.PageBean;
import com.yuzhe.travel.domain.Route;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 21:53
 */
public interface RouteService {

    public PageBean<Route> pageQuery(int cid, int currPage, int pageSize);
}
