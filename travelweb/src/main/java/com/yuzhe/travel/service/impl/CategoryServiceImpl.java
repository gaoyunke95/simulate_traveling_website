package com.yuzhe.travel.service.impl;

import com.yuzhe.travel.dao.CategoryDao;
import com.yuzhe.travel.dao.impl.CategoryDaoImpl;
import com.yuzhe.travel.domain.Category;
import com.yuzhe.travel.service.CategoryService;
import com.yuzhe.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 17:03
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {

        //1。searching on redis first;

        Jedis jedis = JedisUtil.getJedis();
        //2.get sortedset
        Set<Tuple> categories = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs = null;

        if(categories == null || categories.size() == 0){
            cs = categoryDao.findAll();

            for (int i = 0; i < cs.size(); i++){
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {
            //the redis return back is set, convert the set to arraylist;
            cs = new ArrayList<>();
            for (Tuple tuple : categories){
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                cs.add(category);
            }

        }

        return cs;
    }
}
