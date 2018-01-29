package com.zty.web.bookstore.service.impl;

import com.zty.bookstore.dao.TbItemMapper;
import com.zty.bookstore.dao.TbItemParamMapper;
import com.zty.bookstore.pojo.po.TbItem;
import com.zty.bookstore.pojo.po.TbItemParam;
import com.zty.bookstore.pojo.po.TbItemParamExample;
import com.zty.bookstore.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    TbItemParamMapper tbItemParamMapperDao;
    @Override
    public TbItemParam getByCid(Long cid) {
        TbItemParam tbItemParam =null;
        try{
            tbItemParam = new TbItemParam();
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            List<TbItemParam> list = tbItemParamMapperDao.selectByExampleWithBLOBs(example);
            if(list !=null && list.size()>0){
               tbItemParam = list.get(0);
           }
        }catch (Exception e){
            e.printStackTrace();
        }
         return tbItemParam;
        }
}