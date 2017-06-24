/**  
 * Project Name:Dev  
 * File Name:CostListController.java  
 * Package Name:com.gqxie.controller  
 * Date:2017年6月24日上午9:47:04  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.controller;
/**  
 * ClassName:CostListController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月24日 上午9:47:04 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gqxie.dao.ICostDao;
import com.gqxie.entity.Cost;

@Controller
@RequestMapping("/cost")
public class CostListController
{
    @Resource
    private ICostDao costDao;

    @RequestMapping("/list.do")
    public String execute(ModelMap model)
    {
        List<Cost> list = costDao.findAll();
        model.put("costs", list);
        return "fee/fee_list";
    }

}
