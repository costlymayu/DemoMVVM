package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class MyList {
    @SerializedName("id")
    public String id="";

    @SerializedName("name")
    public String artistname="";

    @SerializedName("imageurl")
    public String artistimage="";

    @SerializedName("moviename")
    public String moviename="";

    public MyList(String id, String artistname, String artistimage, String moviename) {
        this.id = id;
        this.artistname = artistname;
        this.artistimage = artistimage;
        this.moviename = moviename;
    }

    public MyList() {
    }
}
