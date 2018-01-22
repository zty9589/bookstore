package com.zty.ttshop.common.dto;

//定义请求参数类
public class Page {

    //当前页码
    private Integer page;
    //每页显示的条数
    private Integer rows;
  /*  //偏移量
    private Integer offSet;*/

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
    public Integer getOffSet() {
        return (page-1)*rows;
    }

}
