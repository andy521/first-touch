package org.jadework.controller;

import com.alibaba.fastjson.JSONObject;
import org.jadework.model.RequestToGroup;
import org.jadework.model.RequestToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WsController {
    @Autowired

    private SimpMessagingTemplate messagingTemplate;

    /**
     * 广播式通信，所有订阅了 /queue/notifications 的用户都能接受
     * @param principal
     * @param msg
     */
    @MessageMapping("/chat")
    public void chat(Principal principal, String msg) {
        System.out.println("请求来自："+principal.getName()+";msg:"+msg);
        messagingTemplate.convertAndSend("/topic/message",msg);
        /*if (principal.getName().equals("admin1")) {
            messagingTemplate.convertAndSendToUser("admin2", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }else{
            messagingTemplate.convertAndSendToUser("admin1", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }*/
    }

    /**
     * 一对一聊天
     * 前端订阅规则：/user/{admin}/message
     * @param principal
     * @param requestToOne
     */
    @MessageMapping("/sendMsgToStaff")
    public void sendMsgToStaff(Principal principal, RequestToOne requestToOne) {
        System.out.println("请求来自："+principal.getName());
        System.out.println("请求到达："+requestToOne);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",principal.getName());
        jsonObject.put("msg",requestToOne.getMsg());
        messagingTemplate.convertAndSendToUser(requestToOne.getToStaff(),"/message",jsonObject.toJSONString());
        /*if (principal.getName().equals("admin1")) {
            messagingTemplate.convertAndSendToUser("admin2", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }else{
            messagingTemplate.convertAndSendToUser("admin1", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }*/
    }

    /**
     * 群组聊天
     * 前端订阅规则：/group/{groupId}/message
     * @param principal
     * @param requestToGroup
     */
    @MessageMapping("/sendMsgToGroup")
    public void sendMsgToGroup(Principal principal, RequestToGroup requestToGroup) {
        System.out.println("请求来自："+principal.getName());
        System.out.println("请求到达组："+requestToGroup);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",principal.getName());
        jsonObject.put("msg",requestToGroup.getMsg());
        messagingTemplate.convertAndSend("/group/"+requestToGroup.getGroupId()+"/message",jsonObject.toJSONString());
    }



}