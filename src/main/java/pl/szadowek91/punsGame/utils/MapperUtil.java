package pl.szadowek91.punsGame.utils;

import pl.szadowek91.punsGame.entity.ImageEntity;
import pl.szadowek91.punsGame.entity.WordEntity;

/**
 * @author PG
 */
public class MapperUtil {

    public static WordEntity wordMapper(String word) {
        return new WordEntity(word);
    }

    public static ImageEntity imageMapper(String imageName, String imgUrl) {return new ImageEntity(imageName, imgUrl);}
}
