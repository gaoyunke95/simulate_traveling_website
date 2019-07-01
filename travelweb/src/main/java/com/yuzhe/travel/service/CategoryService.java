package com.yuzhe.travel.service;

import com.yuzhe.travel.domain.Category;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 17:02
 */
public interface CategoryService {
    public List<Category> findAll();
}
