package com.flatislove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping(value = "/homeuser", method = RequestMethod.GET)
    public ModelAndView doHomeForUser(){
        return new ModelAndView("indexforuser");
    }

    @RequestMapping(value = "/homeadmin", method = RequestMethod.GET)
    public ModelAndView doHomeForAdmin(){
        return new ModelAndView("indexforadmin");
    }
}
