package com.yuzhe.travel.dao;

import com.yuzhe.travel.domain.Category;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 16:34
 */
public interface CategoryDao {

    public List<Category> findAll();
}
