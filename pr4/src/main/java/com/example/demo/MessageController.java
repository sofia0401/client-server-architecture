package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {


    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Response getMessage(Message message) throws Exception {
        return new Response(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

}