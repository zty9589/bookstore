package com.zty.ttshop.common.dto;

public class TreeNode {

    /*
    * 通用的树节点实体类
    * */

    private Long id;
    private String state;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
