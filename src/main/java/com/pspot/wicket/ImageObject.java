package com.pspot.wicket;


import java.io.Serializable;

public class ImageObject implements Serializable {

    byte[] img;

    public ImageObject() {}

    public ImageObject(byte[] img) {
        this.img = img;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
