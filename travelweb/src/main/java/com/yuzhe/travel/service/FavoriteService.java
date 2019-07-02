package com.yuzhe.travel.service;

/**
 * @author Henry Gao
 * @date 2019-07-02 - 09:12
 */
public interface FavoriteService {

    public boolean isFavorite(String rid, int uid);

    public void add(String rid, int uid);
}
