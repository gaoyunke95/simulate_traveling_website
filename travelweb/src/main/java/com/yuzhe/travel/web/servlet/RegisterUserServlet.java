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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Henry Gao
 * @date 2019-06-29 - 08:58
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * check verification code
         */
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("Wrong Verification Code");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return ;
        }

        /**
         * get data from the form
         */
        //1.get data
        Map<String, String[]> map = request.getParameterMap();

        //2.encapsulate object
        User user = new User();

        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //3.service complete register
        UserService service = new UserServiceImpl();
        boolean flag = service.register(user);
        ResultInfo info = new ResultInfo();

        if(flag){
            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("Register Failed: User Already Exists");
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        //

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
