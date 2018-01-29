package com.zty.web.bookstore.service.impl;

import com.zty.bookstore.dao.TbItemCustomMapper;
import com.zty.bookstore.dao.TbItemDescMapper;
import com.zty.bookstore.dao.TbItemMapper;
import com.zty.bookstore.dao.TbItemParamItemMapper;
import com.zty.bookstore.pojo.po.TbItem;
import com.zty.bookstore.pojo.po.TbItemDesc;
import com.zty.bookstore.pojo.po.TbItemExample;
import com.zty.bookstore.pojo.po.TbItemParamItem;
import com.zty.bookstore.service.ItemService;
import com.zty.ttshop.common.dto.Order;
import com.zty.ttshop.common.dto.Page;
import com.zty.ttshop.common.dto.Query;
import com.zty.ttshop.common.dto.Result;
import com.zty.ttshop.common.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    TbItemCustomMapper tbItemCustomMapperDao;
    @Autowired
    TbItemMapper itemDao;
    @Autowired
    TbItemDescMapper tbItemDescDao;
    @Autowired
    TbItemParamItemMapper tbItemParamItemMapperDao;

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

    @Override
    public Integer updataBatch(List<Long> ids) {
        int i=0;
        try{
            //准备了个商品对象，这个商品中包含了状态为3的字段
            TbItem record = new TbItem();
            record.setStatus((byte)3);
            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i = itemDao.updateByExampleSelective(record,example);
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Integer downBatch(List<Long> ids) {
        int i=0;
        try{
            //准备了个商品对象，这个商品中包含了状态为2的字段
            TbItem record = new TbItem();
            record.setStatus((byte)2);
            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i = itemDao.updateByExampleSelective(record,example);
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Integer upBatch(List<Long> ids) {
        int i=0;
        try{
            //准备了个商品对象，这个商品中包含了状态为2的字段
            TbItem record = new TbItem();
            record.setStatus((byte)1);
            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i = itemDao.updateByExampleSelective(record,example);
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String content, String paramDate) {
        int i = 0;
        try{
            //先存tb_item
            //生成随机id
            long itemId = IDUtils.getItemId();
            tbItem.setId(itemId);
            tbItem.setStatus((byte)1);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            i = itemDao.insert(tbItem);

            //再存tb_item_desc
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(itemId);
            tbItemDesc.setItemDesc(content);
            tbItemDesc.setCreated(new Date());
            tbItemDesc.setUpdated(new Date());

            i+= tbItemDescDao.insert(tbItemDesc);

            //最后存规格参数TbItemParamItem
            TbItemParamItem tbItemParamItem = new TbItemParamItem();
            tbItemParamItem.setItemId(itemId);
            tbItemParamItem.setCreated(new Date());
            tbItemParamItem.setUpdated(new Date());
            tbItemParamItem.setParamData(paramDate);

            //tb_item,TbItemParamItem存成功后再存取TbItemParamItem
            i+=tbItemParamItemMapperDao.insert(tbItemParamItem);
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
