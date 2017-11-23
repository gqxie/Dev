package com.gqxie.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gqxie.entity.TApp;
import com.gqxie.entity.TAppExample;
import com.gqxie.entity.TAppExample.Criteria;
import com.gqxie.mapper.TAppMapper;

@RequestMapping("/app")
@Controller
public class AppController
{
    @Autowired
    TAppMapper     appMapper;

    private Logger logger = Logger.getLogger(AppController.class);

    @RequestMapping("/insert")
    @ResponseBody
    public void insert(@RequestParam("appname") String appName, @RequestParam("desc") String desc)
    {
        TApp app = new TApp();
        app.setAppname(appName);
        app.setDescription(desc);
        app.setCreatetime(DateTime.now().toDate());
        app.setUpdatetime(DateTime.now().toDate());
        appMapper.insert(app);
        logger.info("add app success ,id = " + app.getId());
    }

    @RequestMapping("/selectByExample")
    @ResponseBody
    public List<TApp> selectByExample(@RequestParam("name") String name)
    {
        TAppExample example = new TAppExample();
        Criteria criteria = example.createCriteria();
        criteria.andAppnameEqualTo(name);
        return appMapper.selectByExample(example);
    }
}
