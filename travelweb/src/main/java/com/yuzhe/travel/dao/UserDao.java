package com.yuzhe.travel.dao;

import com.yuzhe.travel.domain.User;

/**
 * @author Henry Gao
 * @date 2019-06-29 - 09:45
 */
public interface UserDao {
    /**
     * get user by username
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * find user by the active code;
     * @param code
     * @return
     */
    public User findByCode(String code);

    /**
     * save user info
     * @param user
     */
    public void save(User user);

    public void updateStatus(User user);

}
