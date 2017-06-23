/**  
 * Project Name:Dev  
 * File Name:HelloController.java  
 * Package Name:com.gqxie.controller  
 * Date:2017年6月24日上午6:16:49  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/

package com.gqxie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * ClassName: HelloController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年6月24日 上午6:16:49 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.6
 */
public class HelloController implements Controller
{

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * 
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.getModel().put("msg", "模型数据");
        // 等价于request.setAttribute("msg", "模型数据");
        return mav;
    }

}
