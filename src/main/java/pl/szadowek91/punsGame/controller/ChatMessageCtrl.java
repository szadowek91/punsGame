package pl.szadowek91.punsGame.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.szadowek91.punsGame.model.ChatMessage;

@Controller
public class ChatMessageCtrl {

    @MessageMapping("/chat")
    @SendTo("/topic/messages") // broker name/queue name
    public ChatMessage getMessage(ChatMessage chatMessage) {
        return new ChatMessage(chatMessage.getValue() + "from GUI test1");
    }
}
