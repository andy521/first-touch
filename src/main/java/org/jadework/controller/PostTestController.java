package org.jadework.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/6/17
 */

@RestController
@RequestMapping(value = "/postTest")
public class PostTestController {

    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public JSONObject test1(@RequestParam(required = false, value = "userCode", defaultValue = "1")Integer userCode
            , @RequestBody String map){
        JSONObject jsonObject = new JSONObject();

        System.out.println(map);
        jsonObject.put("userCode",userCode);
        return jsonObject;
    }

    @RequestMapping(value = "/test2",method = RequestMethod.POST)
    public JSONObject test2(@RequestParam(required = false, value = "userCode", defaultValue = "1")Integer userCode
            , @RequestBody Map map){
        JSONObject jsonObject = new JSONObject();
        String company = (String) map.get("company");

        jsonObject.put("userCode",userCode);
        jsonObject.put("company",company);
        return jsonObject;
    }
}
