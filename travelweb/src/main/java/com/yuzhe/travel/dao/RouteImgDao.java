package com.yuzhe.travel.dao;

import com.yuzhe.travel.domain.RouteImg;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-07-01 - 19:30
 */
public interface RouteImgDao {

    public List<RouteImg> findImgByRid(int rid);
}
