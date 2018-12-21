/*
package com.mansocks.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class GreetingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/message")
    //@SendTo("/topic/greetings")
    //接收/app/message发来的value，然后将value转发到/topic/greetings客户端
    public Greeting message(String message) throws Exception {
        //通过convertAndSendToUser 向用户发送信息,
        // 第一个参数是接收消息的用户,第二个参数是浏览器订阅的地址,第三个参数是消息本身
        //messagingTemplate.convertAndSendToUser();
        messagingTemplate.convertAndSend("/topic/greetings", new Greeting(message));
        return null;

    }
}
*/
