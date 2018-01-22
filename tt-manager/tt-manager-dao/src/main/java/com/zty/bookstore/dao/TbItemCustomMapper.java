package com.zty.bookstore.dao;

import com.zty.bookstore.pojo.po.TbItem;
import com.zty.ttshop.common.dto.Page;
import com.zty.ttshop.common.dto.Query;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {
    public List<TbItem> listByPage(Map<String,Object> map);
    public int countTotal(Map<String,Object> map);

}
