package com.example.hp.blogapp;

import com.google.firebase.firestore.FieldValue;

import java.io.Serializable;

public class NewPostModelclass implements Serializable {

    public String description;
    public String tag;
    public String image;
    public String user;
    public String imageThumb;
    public String time;

    NewPostModelclass(){}

     NewPostModelclass(String desc,String Tag,String Image,String User,String Imagethumb,String Time)
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
