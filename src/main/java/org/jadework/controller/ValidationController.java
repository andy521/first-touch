package org.jadework.controller;

import org.jadework.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/7/5
 */

@RestController
public class ValidationController {
    @RequestMapping(value = "/login")
    public String login(@Valid User user, BindingResult result){
        if (result.hasErrors())
            return "user/login";
        return "redirect:/";
    }
}
