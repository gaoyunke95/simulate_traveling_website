package com.yuzhe.travel.web.servlet;

import com.yuzhe.travel.domain.PageBean;
import com.yuzhe.travel.domain.Route;
import com.yuzhe.travel.domain.RouteImg;
import com.yuzhe.travel.domain.Seller;
import com.yuzhe.travel.service.RouteService;
import com.yuzhe.travel.service.impl.RouteServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 21:22
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service = new RouteServiceImpl();
    /**
     * page Query
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

        rname = new String(rname.getBytes("iso-8859-1"),"utf-8");

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

        PageBean<Route> pb = service.pageQuery(cid, currPage, pageSize, rname);
        writeValue(response, pb);


    }

    /**
     * base on the rid searching for the detail of a route
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOneByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ridStr = request.getParameter("rid");
        int rid = Integer.parseInt(ridStr);

        Route route = service.findOneByRid(rid);

        writeValue(response, route);
    }
}
