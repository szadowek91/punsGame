package pl.szadowek91.punsGame.utils;

import pl.szadowek91.punsGame.entity.WordEntity;

/**
 * @author PG
 */
public class WordMapper {

    public static WordEntity wordMapper(String word) {
        return new WordEntity(word);
    }
}
