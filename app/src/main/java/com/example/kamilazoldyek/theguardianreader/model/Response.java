package com.example.kamilazoldyek.theguardianreader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {


    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("userTier")
    @Expose
    public String userTier;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("startIndex")
    @Expose
    public Integer startIndex;
    @SerializedName("pageSize")
    @Expose
    public Integer pageSize;
    @SerializedName("currentPage")
    @Expose
    public Integer currentPage;
    @SerializedName("pages")
    @Expose
    public Integer pages;
    @SerializedName("orderBy")
    @Expose
    public String orderBy;
    @SerializedName("results")
    @Expose
    public List<Result> results = null;
    private final static long serialVersionUID = -5556026566618343343L;

    public String getStatus() {
        return status;
    }

    public String getUserTier() {
        return userTier;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPages() {
        return pages;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public List<Result> getResults() {
        return results;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
