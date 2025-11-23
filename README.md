# Spring Boot WebSocket Notification System

This is a **dummy project** demonstrating the use of **WebSocket** with **Spring Boot** and **Thymeleaf**. It allows real-time message broadcasting to multiple clients through a simple notification system.

---

## Features

- Real-time messaging using **WebSocket + STOMP**.
- Broadcast messages to multiple clients via **topics**.
- Simple UI built with **Thymeleaf**.
- Supports fallback to **SockJS** for clients without native WebSocket support.

---

## Project Structure
```
src/main/java
├── config
│ └── WebSocketConfig.java # WebSocket configuration (endpoints, message broker)
├── controller
│ └── NotificationController.java # REST/WebSocket controller
src/main/resources/templates
├── admin.html # Admin page to send messages
├── user1.html # User page to receive notifications
├── user2.html # Another user page to receive notifications
```

## WebSocket Configuration

`WebSocketConfig.java` defines the WebSocket setup:

```java
@Override
public void configureMessageBroker(MessageBrokerRegistry config) {
    // Configure topic for broadcasting messages
    config.enableSimpleBroker("/topic");
    // Define application destination prefix for sending messages
    config.setApplicationDestinationPrefixes("/notification-app");
}

@Override
public void registerStompEndpoints(StompEndpointRegistry registry) {
    // Define WebSocket endpoint and allow cross-origin requests
    registry.addEndpoint("/notification-system-websocket")
            .setAllowedOrigins("http://localhost:63342")
            .withSockJS(); // Fallback for clients without native WebSocket support
}
