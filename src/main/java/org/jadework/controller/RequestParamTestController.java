package org.jadework.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/6/16
 */

@RestController
@RequestMapping(value = "/test")
public class RequestParamTestController {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public JSONObject test1(@RequestParam(required = true, value = "userCode")Integer userCode){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userCode",userCode);
        return jsonObject;
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public JSONObject test2(@RequestParam(required = true, value = "userCode", defaultValue = "1")Integer userCode){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userCode",userCode);
        return jsonObject;
    }

    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public JSONObject test3(@RequestParam(required = false, value = "userCode")Integer userCode){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userCode",userCode);
        return jsonObject;
    }

    @RequestMapping(value = "/test4",method = RequestMethod.GET)
    public JSONObject test4(@RequestParam(required = false, value = "userCode", defaultValue = "1")Integer userCode){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userCode",userCode);
        return jsonObject;
    }

    @RequestMapping(value = "/test5",method = RequestMethod.GET)
    public JSONObject test5(@RequestParam(required = false, value = "userCode", defaultValue = "1")Integer userCode){
        if(userCode == 5)
            throw new RuntimeException("userCode = 5");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userCode",userCode);
        return jsonObject;
    }
}
