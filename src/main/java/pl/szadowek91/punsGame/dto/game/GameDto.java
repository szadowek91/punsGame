package pl.szadowek91.punsGame.dto.game;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author PG
 */

@Getter
@Setter
public class GameDto {

    private String id;

    private String blindWord;

    private List<String> hintList;

    private String imageUrl;
}
