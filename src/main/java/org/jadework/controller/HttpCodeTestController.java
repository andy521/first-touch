package org.jadework.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/6/16
 */

@RestController
@RequestMapping(value = "/httpCodeTest")
public class HttpCodeTestController {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public ResponseEntity<JSONObject> test1(@RequestParam(required = true, value = "userCode")Integer userCode){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","后台处理异常");
        jsonObject.put("code",417);
//        return new ResponseEntity<>("The String ResponseBody with custom status code (403 Forbidden - stephansun)",
//                HttpStatus.EXPECTATION_FAILED);
                return new ResponseEntity<>(jsonObject,
                HttpStatus.EXPECTATION_FAILED);
    }
}
