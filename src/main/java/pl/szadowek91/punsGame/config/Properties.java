package pl.szadowek91.punsGame.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author PG
 */
public class Properties {

    public static final String NAME = "Puns - the game";
    public static final String VERSION = "2022_10_29_v1";

    public static final String DICTIONARY_API_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";
    public static final String PIXABAY_API_MAIN_URL = "https://pixabay.com/api/";

    public static final String SPRING_DATASOURCE_USERNAME = "SYSDBA";
    public static final String SPRING_DATASOURCE_PASSWORD = "masterkey";
    public static final String SPRING_DATASOURCE_URL = "jdbc:firebirdsql://localhost:3050/D:\\\\BazyDanychLokalne\\\\punsWordData.fdb";
    public static final String DRIVER_CLASS_NAME = "org.firebirdsql.jdbc.FBDriver";

}
