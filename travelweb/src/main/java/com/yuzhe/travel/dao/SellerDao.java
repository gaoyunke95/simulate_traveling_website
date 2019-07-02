package com.yuzhe.travel.dao;

import com.yuzhe.travel.domain.Seller;

/**
 * @author Henry Gao
 * @date 2019-07-01 - 19:31
 */
public interface SellerDao {

    public Seller findSellerBySid(int sid);
}
