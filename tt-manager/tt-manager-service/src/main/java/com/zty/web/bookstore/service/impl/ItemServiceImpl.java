package com.zty.web.bookstore.service.impl;

import com.zty.bookstore.dao.TbItemCustomMapper;
import com.zty.bookstore.pojo.po.TbItem;
import com.zty.bookstore.service.ItemService;
import com.zty.ttshop.common.dto.Order;
import com.zty.ttshop.common.dto.Page;
import com.zty.ttshop.common.dto.Query;
import com.zty.ttshop.common.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    TbItemCustomMapper tbItemCustomMapperDao;

    @Override
    public Result<TbItem> listByPage(Page page, Query query,Order order) {
        List<TbItem> tbItemList = null;
        Result result = null;
        Map<String,Object> map = null;

        try{
            map = new HashMap<>();
            //将page封装进map
            map.put("page",page);
            //将query封装进map
            map.put("query",query);
            //将order(分类参数的类)
            map.put("order",order);
            //定义一个分页的响应对象
            result =new Result();
            //查询每页的记录数封装成的集合
            tbItemList = tbItemCustomMapperDao.listByPage(map);
            //查询符合条件的总记录数
            int total = tbItemCustomMapperDao.countTotal(map);
            //设置集合
            result.setRows(tbItemList);
            //设置符合条件的总记录数
            result.setTotal(total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
