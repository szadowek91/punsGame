package pl.szadowek91.punsGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szadowek91.punsGame.service.DictService;
import pl.szadowek91.punsGame.service.ImageService;
import pl.szadowek91.punsGame.service.WordService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author PG
 */
@Controller
public class MainCtrl {

    private final WordService wordService;
    private final DictService dictService;
    private final ImageService imageService;
    public MainCtrl(WordService wordService, DictService dictService, ImageService imageService) {
        this.wordService = wordService;
        this.dictService = dictService;
        this.imageService = imageService;
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
            String collectedHints = String.join(" \n || ", hintsFromAPI);
            String imageUrl = imageService.getImageURL(randomWord);

            session.setAttribute("hintList", collectedHints);
            session.setAttribute("blindWord", actualWord);
            session.setAttribute("word", randomWord);
            session.setAttribute("imageUrl", imageUrl);
        }
        String word = (String) session.getAttribute("word");
        String actualWord = (String) session.getAttribute("blindWord");
        String hintsFromAPI = (String) session.getAttribute("hintList");
        String imageUrl = (String) session.getAttribute("imageUrl");

        model.addAttribute("blindWord", actualWord);
        model.addAttribute("hintList", hintsFromAPI);
        model.addAttribute("imageUrl", imageUrl);
        model.addAttribute("word", word); // at the end to remove (for review purposes)

        return "punsGame";
    }

    @PostMapping("/enteredPhrase")
    public String enteredPhrase(@RequestParam("inputWord") String inputWord, HttpSession session){
        String word = (String) session.getAttribute("word");

        boolean isWordGuessed = wordService.checkWord(inputWord, word);
        session.setAttribute("wordGuessed", isWordGuessed);

        return "redirect:/";
    }

    @PostMapping("/newGame")
    public String newGame(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
