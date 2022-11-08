package pl.szadowek91.punsGame.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.List;
import java.util.UUID;

/**
 * @author PG
 */
@Getter
@Setter
public class GameEntity {

    @Transient
    @Setter(AccessLevel.NONE)
    private UUID id = UUID.randomUUID();

    private String wordToGuess;

    private String blindWord;

    private List<String> hintList;

    private String imageUrl;

}
