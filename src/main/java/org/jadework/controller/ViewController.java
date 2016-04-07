package org.jadework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @version 1.0
 * @Copyright Copyright (c) 2016,
 * @Title
 * @Description View Control
 * @date 16/02/26
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showView(){
        return "main";
    }
}


