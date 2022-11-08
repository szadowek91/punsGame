package pl.szadowek91.punsGame.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.szadowek91.punsGame.model.ChatMessage;
import pl.szadowek91.punsGame.service.GameService;

@Controller
public class ChatMessageCtrl {

    private GameService gameService;

    public ChatMessageCtrl(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages") // broker name/queue name
    public ChatMessage getMessage(ChatMessage chatMessage) {
        ChatMessage message = chatMessage;
        boolean isGuessed = gameService.isWordCorrect(chatMessage.getValue());
        if (isGuessed){
            message = new ChatMessage(chatMessage.getValue() + " || <<- THIS IS CORRECT WORD ! - CONGRATS!");
        } else {
            message = new ChatMessage(chatMessage.getValue() + " || GUI test");
        }
        return message;
    }

}
