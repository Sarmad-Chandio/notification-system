package com.sarmad.notificationsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfigClass implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // configuring here topic
        config.enableSimpleBroker("/topic"); //to broad cast the message
        config.setApplicationDestinationPrefixes("/notification-app"); // to define end point
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // configuring here reistry, mean how other services can communicate with our service
        //in other words we are providing subscription here, and defining rules
        registry.addEndpoint("/notification-system-websocket")
                .setAllowedOrigins("http://localhost:63342")//for now this is public, everyone can access
                .withSockJS();// fall back
    }
}
