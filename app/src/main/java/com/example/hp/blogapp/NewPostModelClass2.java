package com.example.hp.blogapp;

public class NewPostModelClass2 {
    private String description;
    private String tag;
    private String image;
    private String user;
    private String imageThumb;
    private String time;


    NewPostModelClass2(){}

    NewPostModelClass2(String desc, String Tag, String Image, String User, String Imagethumb, String Time)
    {
        this.description = desc;
        this.tag = Tag;
        this.image = Image;
        this.user = User;
        this.imageThumb = Imagethumb;
        this.time = Time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

