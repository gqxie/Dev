/**  
 * Project Name:Dev  
 * File Name:ToLoginController.java  
 * Package Name:com.gqxie.controller  
 * Date:2017年6月24日上午7:31:28  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/

package com.gqxie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * ClassName:ToLoginController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月24日 上午7:31:28 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.6
 * @see
 */
public class ToLoginController implements Controller
{

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * 
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse) throws Exception
    {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

}
