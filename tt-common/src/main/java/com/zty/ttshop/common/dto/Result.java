package com.zty.ttshop.common.dto;


import java.util.List;

/*
* 定义分页响应的参数类
* */
public class Result<T> {

    //符合条件的总记录数
    private Integer total;
    //每页的记录数封装成的集合
    private List<T> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
