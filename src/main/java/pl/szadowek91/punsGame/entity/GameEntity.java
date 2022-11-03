package pl.szadowek91.punsGame.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

/**
 * @author PG
 */
@Getter
@Setter
public class GameEntity {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    private String wordToGuess;

    private String blindWord;

    private List<String> hintList;

    private String imageUrl;

}
