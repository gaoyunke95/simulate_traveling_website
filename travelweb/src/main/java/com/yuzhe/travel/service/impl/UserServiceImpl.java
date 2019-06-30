package com.yuzhe.travel.service.impl;

import com.yuzhe.travel.dao.UserDao;
import com.yuzhe.travel.dao.impl.UserDaoImpl;
import com.yuzhe.travel.domain.User;
import com.yuzhe.travel.service.UserService;
import com.yuzhe.travel.util.MailUtils;
import com.yuzhe.travel.util.UuidUtil;

/**
 * @author Henry Gao
 * @date 2019-06-29 - 09:43
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * register user
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {

        //get searched user
        User u = userDao.findByUsername(user.getUsername());
        //if the user is not null return false; means already exists
        if (u != null) {
            return false;
        }

        //randomly generate a active code
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");

        //the user haven't been active
        userDao.save(user);

        //send out a active email

        //if deploye using domain name
        String content = "<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+ "'> click here to active Your [travel_website account] </a>";
        MailUtils.sendMail(user.getEmail(), content, "active email");
        return true;
    }

    /**
     * active the account by the code;
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {

        User user = userDao.findByCode(code);

        if (user != null) {
            userDao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {

        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }


}
