package pl.szadowek91.punsGame.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.*;

@Entity
@Getter
public class ImageEntity {

    @Id
    private int id;
    private String name;
    private String imgUrl;


    public ImageEntity(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }

}
