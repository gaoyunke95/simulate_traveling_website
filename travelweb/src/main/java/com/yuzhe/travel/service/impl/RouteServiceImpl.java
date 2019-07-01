package com.yuzhe.travel.service.impl;

import com.yuzhe.travel.dao.RouteDao;
import com.yuzhe.travel.dao.impl.RouteDaoImpl;
import com.yuzhe.travel.domain.PageBean;
import com.yuzhe.travel.domain.Route;
import com.yuzhe.travel.service.RouteService;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 22:45
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currPage, int pageSize, String rname) {
        PageBean<Route> pb = new PageBean<Route>();
        pb.setCurrPage(currPage);
        pb.setPageSize(pageSize);

        int totalCount = routeDao.findTotalCount(cid, rname);
        pb.setTotalCount(totalCount);

        int start = (currPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pb.setList(list);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
