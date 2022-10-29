package pl.szadowek91.punsGame.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.*;

@Entity
public class ImageEntity {

    @Id
    private int id;
    private String name;
    private Image img;

    public ImageEntity(String name, Image img) {
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Image getImg() {
        return img;
    }
}
