package pl.szadowek91.punsGame.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szadowek91.punsGame.dto.game.GameDto;
import pl.szadowek91.punsGame.entity.GameEntity;
import pl.szadowek91.punsGame.repository.GameRepo;

/**
 * @author PG
 */
@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepo gameRepo;
    private final WordService wordService;
    private final DictService dictService;
    private final ImageService imageService;

    private GameEntity getGameE() {
        GameEntity game = gameRepo.getGame();
        if (game == null) {
            return createGame();
        }
        return game;
    }

    public GameEntity createGame() {
        GameEntity game = new GameEntity();
        String randomWord = wordService.selectRandomWord();
        game.setWordToGuess(randomWord);
        game.setBlindWord(wordService.initShowActualWord(randomWord));
        game.setHintList(dictService.getHints(randomWord));
        game.setImageUrl(imageService.getImageURL(randomWord));
        gameRepo.setGame(game);
        return gameRepo.getGame();
    }

    public GameDto getGame(){
        GameDto gameDto = new GameDto();
        GameEntity gameE = getGameE();
        gameDto.setBlindWord(gameE.getBlindWord());
        gameDto.setHintList(gameE.getHintList());
        gameDto.setImageUrl(gameE.getImageUrl());
        gameDto.setId(gameE.getId());
        return gameDto;
    }

}
