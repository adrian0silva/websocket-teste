package net.javaguides.springboot.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

import net.javaguides.springboot.websocket.model.Greeting;
import net.javaguides.springboot.websocket.model.HelloMessage;

@Controller
@CrossOrigin("*")
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("MUDEI, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
