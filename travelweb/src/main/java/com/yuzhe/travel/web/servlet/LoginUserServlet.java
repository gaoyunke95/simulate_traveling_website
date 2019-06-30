package com.yuzhe.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuzhe.travel.domain.ResultInfo;
import com.yuzhe.travel.domain.User;
import com.yuzhe.travel.service.UserService;
import com.yuzhe.travel.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Henry Gao
 * @date 2019-06-29 - 20:41
 */
@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImpl();
        User u = service.login(user);

        ResultInfo info = new ResultInfo();
        if (u == null){
            info.setFlag(false);
            info.setErrorMsg("Wrong Username or Password");
        }

        if(u != null && (!"Y".equals(u.getCode()))){
            info.setFlag(false);
            info.setErrorMsg("Your account haven't been active, please active first");
        }

        if(u != null && "Y".equals(u.getCode())){
            request.getSession().setAttribute("user",u);
            info.setFlag(true);
        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
