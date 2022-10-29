package pl.szadowek91.punsGame.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author PG
 */
public class Properties {

    public static final String NAME = "Puns - the game";
    public static final String VERSION = "2022_10_29_v1";

    @Value("${API_KEY}")
    private String API_KEY;

    public static final String SPRING_DATASOURCE_USERNAME = "SYSDBA";
    public static final String SPRING_DATASOURCE_PASSWORD = "masterkey";
    public static final String SPRING_DATASOURCE_URL = "jdbc:firebirdsql://localhost:3050/D:\\\\BazyDanychLokalne\\\\punsWordData.fdb";
    public static final String DRIVER_CLASS_NAME = "org.firebirdsql.jdbc.FBDriver";


    public String getAPI_KEY() {
        return API_KEY;
    }
    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }
}
