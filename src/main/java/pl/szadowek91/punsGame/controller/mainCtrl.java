package pl.szadowek91.punsGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szadowek91.punsGame.service.DictService;
import pl.szadowek91.punsGame.service.WordService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author PG
 */
@Controller
public class mainCtrl {

    private final WordService wordService;
    private final DictService dictService;

    public mainCtrl(WordService wordService, DictService dictService) {
        this.wordService = wordService;
        this.dictService = dictService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping()
    public String game(Model model, HttpSession session) {
        if (session.getAttribute("word") == null) {
            String randomWord = wordService.selectRandomWord();
            String actualWord = wordService.initShowActualWord(randomWord);
            List<String> hintsFromAPI = dictService.getHints(randomWord);
            String collectedHints = String.join(" || \n", hintsFromAPI);

            session.setAttribute("hint", collectedHints);
            session.setAttribute("actualWord", actualWord);
            session.setAttribute("word", randomWord);
        }
        String word = (String) session.getAttribute("word");
        String actualWord = (String) session.getAttribute("actualWord");
        String hintsFromAPI = (String) session.getAttribute("hint");

        model.addAttribute("actualWord", actualWord);
        model.addAttribute("hint", hintsFromAPI);
        model.addAttribute("word", word); // at the end to remove (for review purposes)

        return "punsGame";
    }

    @PostMapping("/enteredPhrase")
    public String enteredLetter(@RequestParam("inputWord") String inputWord, HttpSession session){
        String word = (String) session.getAttribute("word");
        String actualWord = (String) session.getAttribute("actualWord");

        return "redirect:/";
    }

    @PostMapping("/newGame")
    public String newGame(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
