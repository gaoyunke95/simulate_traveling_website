package com.yuzhe.travel.domain;

import java.util.List;

/**
 * @author Henry Gao
 * @date 2019-06-30 - 21:19
 */
public class PageBean<T> {

    private int totalCount; //total counts of records
    private int totalPage;
    private int currPage;
    private int pageSize; //records to display on each page;
    private List<T> list; // the collection of records on each page;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
