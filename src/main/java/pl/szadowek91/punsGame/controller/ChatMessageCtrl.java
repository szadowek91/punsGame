package pl.szadowek91.punsGame.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.szadowek91.punsGame.model.ChatMessage;
import pl.szadowek91.punsGame.service.WordService;

import javax.servlet.http.HttpSession;

@Controller
public class ChatMessageCtrl {

    private WordService wordService;

    public ChatMessageCtrl(WordService wordService) {
        this.wordService = wordService;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages") // broker name/queue name
    public ChatMessage getMessage(ChatMessage chatMessage) {
//        String incomingWord = chatMessage.getValue();
//        String actualWord = getActualWord();
//        wordService.checkWord(incomingWord, actualWord);
        ChatMessage message = new ChatMessage(chatMessage.getValue() + "from GUI test1");
        return message;
    }

    private String getActualWord(HttpSession session) {
        try {
            if (session.getAttribute("word") == null || session.getAttribute("word").equals("")) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (String) session.getAttribute("word");
    }
}
