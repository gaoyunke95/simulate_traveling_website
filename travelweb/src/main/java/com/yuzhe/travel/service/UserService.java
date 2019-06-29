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
    public boolean active(String code);
}
