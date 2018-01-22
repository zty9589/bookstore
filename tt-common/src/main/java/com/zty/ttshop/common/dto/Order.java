package com.zty.ttshop.common.dto;

import java.util.ArrayList;
import java.util.List;

/*
* 封装一个用于排序的参数类
* */
public class Order {

    //用于排序的字段
    private String sort;
    //排序的方式（升序或者降序）
    private String order;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<String> getOrderParams(){
        //将排序的字段在逗号处切开
        String[] sorts = sort.split(",");
        //将排序的方式在逗号处切开
        String[] orders = order.split(",");
        List<String> list = new ArrayList<>();
        for(int i=0;i<sorts.length;i++){
            String temp = sorts[i] + " " + orders[i];
            list.add(temp);
        }
        return list;
    }
}
