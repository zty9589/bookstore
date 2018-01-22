package com.zty.bookstore.service;

import com.zty.bookstore.pojo.po.TbItem;
import com.zty.ttshop.common.dto.Order;
import com.zty.ttshop.common.dto.Page;
import com.zty.ttshop.common.dto.Query;
import com.zty.ttshop.common.dto.Result;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface ItemService {

     Result<TbItem> listByPage(Page page,Query query,Order order);


}
