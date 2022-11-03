package pl.szadowek91.punsGame.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import pl.szadowek91.punsGame.entity.GameEntity;

/**
 * @author PG
 */
@Repository
@Getter
@Setter
public class GameRepo {

    private GameEntity game;

}
