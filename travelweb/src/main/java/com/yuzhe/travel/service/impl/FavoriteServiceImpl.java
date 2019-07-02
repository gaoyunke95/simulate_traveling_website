package com.yuzhe.travel.service.impl;

import com.yuzhe.travel.dao.FavoriteDao;
import com.yuzhe.travel.dao.impl.FavoriteDaoImpl;
import com.yuzhe.travel.domain.Favorite;
import com.yuzhe.travel.service.FavoriteService;

/**
 * @author Henry Gao
 * @date 2019-07-02 - 09:26
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {

        Favorite favorite = favoriteDao.findByUidAndRid(Integer.parseInt(rid), uid);

        return favorite != null ? true : false;
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid), uid);
    }
}
