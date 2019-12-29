package com.itvsme.ChatWebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessagesController
{
    @MessageMapping("/chat")
    @SendTo("/broker/messages")
    public OutputMessage send(InputMessage message)
    {
        String outputTime = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getUserName(), message.getMessageContent(), outputTime);
    }
}
