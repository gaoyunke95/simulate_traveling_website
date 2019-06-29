package com.yuzhe.travel.service.impl;

import com.yuzhe.travel.dao.UserDao;
import com.yuzhe.travel.dao.impl.UserDaoImpl;
import com.yuzhe.travel.domain.User;
import com.yuzhe.travel.service.UserService;

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
        User u = userDao.findByUsername(user.getUsername());
        if (u != null) {
            return false;
        } else {
            userDao.save(user);
        }
        return true;
    }
}
