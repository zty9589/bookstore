package com.zty.bookstore.web;

import com.zty.bookstore.pojo.po.TbItem;
import com.zty.bookstore.service.ItemService;
import com.zty.ttshop.common.dto.Order;
import com.zty.ttshop.common.dto.Page;
import com.zty.ttshop.common.dto.Query;
import com.zty.ttshop.common.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    ItemService itemService;

    @RequestMapping("/items")
    @ResponseBody
    public Result<TbItem> listByPage(Page page, Query query, Order order,HttpServletRequest request){
        Result<TbItem> result = null;
        String title = request.getParameter("title");
        try{
            if(title !=null && title !=""){
                String s = new String(title.getBytes("ISO-8859-1"));
                query.setTitle(s);
            }
            result = itemService.listByPage(page,query,order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
   /* @RequestMapping("items/batch")
    @ResponseBody
    public int updataBatch(@RequestParam("ids[]") List<Long> ids){
        Integer i=0;
        try{
             i = itemService.updataBatch(ids);
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }*/
}
