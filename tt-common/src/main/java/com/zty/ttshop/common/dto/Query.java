package com.zty.ttshop.common.dto;

/*
* 封装模糊查找的参数
* */
public class Query {

    //商品标题
    private String title;
    //商品状态
    private int status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
