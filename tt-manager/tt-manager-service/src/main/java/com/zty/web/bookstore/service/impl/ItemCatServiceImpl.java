package com.zty.web.bookstore.service.impl;

import com.zty.bookstore.dao.TbItemCatMapper;
import com.zty.bookstore.pojo.po.TbItemCat;
import com.zty.bookstore.pojo.po.TbItemCatExample;
import com.zty.bookstore.service.ItemCatService;
import com.zty.ttshop.common.dto.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    TbItemCatMapper itemCatMapper;
    @Override
    public List<TreeNode> listItemCatsByPid(Long parentId) {
        List<TreeNode> treeNodeList = null;
        try{
            //创建查询模板
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            List<TbItemCat> tbItemCatList = itemCatMapper.selectByExample(example);
            treeNodeList = new ArrayList<>();
            for(int i=0;i<tbItemCatList.size();i++){
                TbItemCat tbItemCat = tbItemCatList.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId(tbItemCat.getId());
                treeNode.setText(tbItemCat.getName());
                treeNode.setState(tbItemCat.getIsParent()? "closed":"open");

                treeNodeList.add(treeNode);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return treeNodeList;
    }

}
