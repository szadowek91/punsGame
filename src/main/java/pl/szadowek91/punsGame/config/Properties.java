package pl.szadowek91.punsGame.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author PG
 */
public class Properties {

    public static final String NAME = "Puns - the game";
    public static final String VERSION = "2022_10_29_v1";

    @Value("${PIXABAY_API_KEY}")
    private String PIXABAY_API_KEY;

    public static final String DICTIONARY_API_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    public static final String SPRING_DATASOURCE_USERNAME = "SYSDBA";
    public static final String SPRING_DATASOURCE_PASSWORD = "masterkey";
    public static final String SPRING_DATASOURCE_URL = "jdbc:firebirdsql://localhost:3050/D:\\\\BazyDanychLokalne\\\\punsWordData.fdb";
    public static final String DRIVER_CLASS_NAME = "org.firebirdsql.jdbc.FBDriver";


    public String getPIXABAY_API_KEY() {
        return PIXABAY_API_KEY;
    }
    public void setPIXABAY_API_KEY(String PIXABAY_API_KEY) {
        this.PIXABAY_API_KEY = PIXABAY_API_KEY;
    }
}
