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
     * find user by username and password;
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password);

    /**
     * save user info
     * @param user
     */
    public void save(User user);

    /**
     * update the account status after being active
     * @param user
     */
    public void updateStatus(User user);



}
