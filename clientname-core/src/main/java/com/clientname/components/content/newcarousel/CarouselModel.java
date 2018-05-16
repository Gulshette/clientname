package com.clientname.components.content.newcarousel;


import java.util.Date;

public class CarouselModel {
    private String imageTitle;
    private String imagePath;
    private Date lastModified;
    //private String number;

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    /*

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }*/
}
