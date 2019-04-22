package com.example.kamilazoldyek.theguardianreader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class News implements Serializable {


    @SerializedName("response")
    @Expose
    public Response response;
    private final static long serialVersionUID = 5354050128885028891L;

    public Response getResponse() {
        return response;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
