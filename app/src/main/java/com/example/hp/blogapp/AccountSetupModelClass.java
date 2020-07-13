package com.example.hp.blogapp;

public class AccountSetupModelClass {
    private String Name;
    private String Contact;
    private String Address;
    private String Introduction;
    private String ImageUri;
    private String EmailID;
    private String UID;


    public AccountSetupModelClass(){}


    public AccountSetupModelClass(String Name,String con,String add,String intro,String imgUri,String emailid,String Uid)
    {
        this.Name = Name;
        this.Contact = con;
        this.Address = add;
        this.Introduction = intro;
        this.ImageUri = imgUri;
        this.EmailID = emailid;
        this.UID = Uid;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getImageUri() {
        return ImageUri;
    }

    public void setImageUri(String imageUri) {
        ImageUri = imageUri;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }
}
