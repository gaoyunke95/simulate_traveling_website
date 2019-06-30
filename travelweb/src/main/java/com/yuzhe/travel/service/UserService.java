package com.yuzhe.travel.service;

import com.yuzhe.travel.domain.User;

/**
 * @author Henry Gao
 * @date 2019-06-29 - 09:42
 */
public interface UserService {

    /**
     * register user
     * @param user
     * @return
     */
    public boolean register(User user);

    /**
     * active the account by the code;
     * @param code
     * @return
     */
    public boolean active(String code);

    /**
     * login method
     * @param user
     * @return
     */
    public User login(User user);
}
