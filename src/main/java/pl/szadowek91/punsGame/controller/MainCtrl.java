package pl.szadowek91.punsGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szadowek91.punsGame.service.GameService;
import pl.szadowek91.punsGame.service.WordService;

import javax.servlet.http.HttpSession;

/**
 * @author PG
 */
@Controller
public class MainCtrl {

    private final WordService wordService;
    private final GameService gameService;

    public MainCtrl(WordService wordService, GameService gameService) {
        this.wordService = wordService;
        this.gameService = gameService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping()
    public String game(Model model) {
        model.addAttribute("game", gameService.getGame());
        return "punsGame";
    }

    @PostMapping("/enteredPhrase")
    public String enteredPhrase(@RequestParam("msgToSend") String inputWord, HttpSession session) {
        String word = (String) session.getAttribute("word");

        boolean isWordGuessed = wordService.checkWord(inputWord, word);
        session.setAttribute("wordGuessed", isWordGuessed);

        return "redirect:/";
    }

    @PostMapping("/newGame")
    public String newGame(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}