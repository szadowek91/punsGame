package pl.szadowek91.punsGame.dto.game;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * @author PG
 */

@Getter
@Setter
public class GameDto {

    private UUID id;

    private String blindWord;

    private List<String> hintList;

    private String imageUrl;
}
