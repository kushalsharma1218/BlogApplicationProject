package com.example.hp.blogapp;

//import java.sql.Timestamp;


import java.util.Date;

//THIS IS THE MODEL CLASS
public class BlogPost extends BlogPostId {

    public String image, imageThumb, description,user,tag;
    public String time;



    //MUST ADD NEEDED
    public BlogPost(){

    }

    public BlogPost(String image_url, String image_thumb, String desc, String user_id,String timeStamp) {
        this.image = image_url;
        this.imageThumb = image_thumb;
        this.description = desc;
        this.user = user_id;
       this.time = timeStamp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
