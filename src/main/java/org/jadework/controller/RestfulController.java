package org.jadework.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class RestfulController {
    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public JSONObject view(Principal principal) {
        System.out.println(principal);
        System.out.println(principal.getName());
        String name = principal.getName();
        JSONObject user = new JSONObject();
        user.put("name",name);

        List<String> list = Arrays.asList("admin1","admin2","admin3");
        list = list.stream().filter( item -> !Objects.equals(item,name)).collect(Collectors.toList());
        user.put("staffList",list);
        return user;
    }
}
