package com.example.zenghong.myapplication;

import java.io.Serializable;

/**
 * Created by zenghong on 16/6/28.
 */
public class ViewPageMember implements Serializable{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private int image;
    private String name;

    public ViewPageMember(int id, int image, String name) {
        super();
        this.id = id;
        this.image = image;
        this.name = name;
    }
}
