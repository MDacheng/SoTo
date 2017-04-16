package com.mdc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mengdacheng on 2017/4/7.
 */
@Entity(name="background")
public class Background {
    private int id;
    private String keyword;
    private String thumbnail;
    private String image;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Column(name="thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
