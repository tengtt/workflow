package org.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by teng on 2016/5/19.
 */
@Controller
@RequestMapping(value="/")
public class TestController {

    @RequestMapping(value="/viewAll")
    public ModelAndView viewAll(String name, String password){
        ModelAndView mv = new ModelAndView();
        System.out.println("进入了控制器");
        System.out.println("name ==== " + name);
        System.out.println("password ==== " + password);
        mv.setViewName("hello");
        mv.addObject("msg","viewAll 返回的视图数据");
        return mv;
    }


    @RequestMapping(value="/query")
    public ModelAndView query(String name, String password){
        ModelAndView mv = new ModelAndView();
        System.out.println("进入了控制器");
        System.out.println("name ==== "+ name);
        System.out.println("password ==== "+ password);
        mv.setViewName("hello");
        return mv;
    }

}
