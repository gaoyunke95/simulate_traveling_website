package com.yuzhe.travel.dao;

import com.yuzhe.travel.domain.Favorite;
import com.yuzhe.travel.domain.Route;

/**
 * @author Henry Gao
 * @date 2019-07-02 - 09:10
 */
public interface FavoriteDao {


    public Favorite findByUidAndRid(int rid, int uid);

    public int findCountByRid(int rid);

    public void add(int rid, int uid);
}
