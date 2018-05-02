package com.clientname.components.content.gallery

import com.clientname.annotations.MultiCompositeFieldItem

@MultiCompositeFieldItem
class ImageItem {

    String getImagePath() {
        return imagePath
    }

    void setImagePath(String imagePath) {
        this.imagePath = imagePath
    }

    String getImageTitle() {
        return imageTitle
    }

    void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle
    }
    private String imagePath

    private String imageTitle
}
