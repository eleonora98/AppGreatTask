package com.example.appgreattask.ImagesFragment;


public class ImageItem {
    private String imageUrl, tags;

    public ImageItem(String imageUrl, String tags){
        this.imageUrl = imageUrl;
        this.tags = tags;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTags() {
        return tags;
    }


}
