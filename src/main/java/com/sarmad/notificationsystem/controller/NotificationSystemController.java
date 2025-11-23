package com.sarmad.notificationsystem.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationSystemController {

    //configuration for topic, and where to send
    @MessageMapping("/sendNotification")//-> default pick url from config : notification-app/sendNotification
    @SendTo("/topic/notificaton")//configutre topic same as config
    public String sendNotification(String message){
        System.out.println("message :"+message);
        return message;
    }
}
