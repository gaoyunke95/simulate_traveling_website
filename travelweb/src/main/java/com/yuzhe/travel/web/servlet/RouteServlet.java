package com.yuzhe.travel.web.servlet;

import com.yuzhe.travel.domain.*;
import com.yuzhe.travel.service.FavoriteService;
import com.yuzhe.travel.service.RouteService;
import com.yuzhe.travel.service.impl.FavoriteServiceImpl;
import com.yuzhe.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 21:22
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    /**
     * page Query
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currPageStr = request.getParameter("currPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String rname = request.getParameter("rname");

        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");

        int cid = 0;
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

        int currPage = 0; //if there is no currPageStr pass in default is first page
        if (currPageStr != null && currPageStr.length() > 0) {
            currPage = Integer.parseInt(currPageStr);
        } else {
            currPage = 1;
        }

        int pageSize = 0;// if no pageSizeStr passed in default show 5 records
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        if ("null".equals(rname)) {
            rname = "";
        }

        PageBean<Route> pb = routeService.pageQuery(cid, currPage, pageSize, rname);
        writeValue(response, pb);


    }

    /**
     * base on the rid searching for the detail of a route
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOneByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ridStr = request.getParameter("rid");
        int rid = Integer.parseInt(ridStr);

        Route route = routeService.findOneByRid(rid);

        writeValue(response, route);
    }


    /**
     * determine if login user has the favorite routes or not ;
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");

        User user = (User) request.getSession().getAttribute("user");

        int uid;
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }

        boolean flag = favoriteService.isFavorite(rid, uid);

        writeValue(response, flag);
    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");

        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            return ;
        } else {
            uid = user.getUid();
        }

        favoriteService.add(rid, uid);

    }
}