package com.example.alex.beer.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
/**
 * Created by alex on 6/4/17.
 */
public class Beer {
    private  String name;
    private String winery;
    private String varietal;
    private String price;
    private String vintage;
    private String type;
    private String link;
    private String region;
    private String image;



    //    private String mCreateDate;
//    private String mUpdateDate;
    public Beer(){}
    public Beer(String name, String winery, String varietal, String price, String vintage, String type, String link, String region, String image) {
        this.name = name;
        this.winery = winery;
        this.varietal = varietal;
        this.price = price;
        this.vintage = vintage;
        this.type = type;
        this.link = link;
        this.region = region;
        this.image = image;
    }




    public String getName() {
        return name;
    }

    public String getWinery() {
        return winery;
    }

    public String getVarietal() {
        return varietal;
    }

    public String getPrice() {
        return price;
    }

    public String getVintage() {
        return vintage;
    }

    public String getType() {
        return type;
    }

    public String getLink() {
        return link;
    }

    public String getRegion() {
        return region;
    }

    public String getImage() {
        return image;
    }
}