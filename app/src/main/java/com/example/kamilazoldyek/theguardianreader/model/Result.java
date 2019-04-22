package com.example.kamilazoldyek.theguardianreader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {



    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("sectionId")
    @Expose
    public String sectionId;
    @SerializedName("sectionName")
    @Expose
    public String sectionName;
    @SerializedName("webPublicationDate")
    @Expose
    public String webPublicationDate;
    @SerializedName("webTitle")
    @Expose
    public String webTitle;
    @SerializedName("webUrl")
    @Expose
    public String webUrl;
    @SerializedName("apiUrl")
    @Expose
    public String apiUrl;
    private final static long serialVersionUID = 6373543393144890950L;

    public String getId() {
        return id;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
