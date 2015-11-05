package com.balinasoft.cartalk.model;

import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("user_name")
    private String user_name;

    @SerializedName("user_mail")
    private String user_mail;

    @SerializedName("user_phone")
    private String user_phone;

    @SerializedName("user_login")
    private String user_login;

    @SerializedName("user_password")
    private String user_password;

    @SerializedName("user_photo")
    private String user_photo;

    @SerializedName("auto")
    private Auto[] auto;

}
