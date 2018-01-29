package com.zty.bookstore.service;

import com.zty.ttshop.common.dto.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.List;

public interface ItemCatService {
    public List<TreeNode> listItemCatsByPid(Long parentId);
}
