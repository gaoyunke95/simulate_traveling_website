package com.yuzhe.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuzhe.travel.domain.Category;
import com.yuzhe.travel.service.CategoryService;
import com.yuzhe.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 17:05
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> cs = service.findAll();

        //.serialize json
        /*
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),cs);*/

        writeValue(response, cs);

    }


}
