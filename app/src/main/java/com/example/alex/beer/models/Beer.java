package com.example.alex.beer.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
/**
 * Created by alex on 6/4/17.
 */
public class Beer {
    private String mName;
    private String mId;
    private String mType;
    private String mIsJuicy;
    private String mIsBaseSpirit;
    private String mIsAlcoholic;
    private String mIsCarbonated;
    private String mDescription;

//    private String mCreateDate;
//    private String mUpdateDate;
    public Beer(){}
    public Beer(String name, String id, String type, String isJuicy, String isBaseSpirit, String isCarbonated,String isAlcoholic,  String description) {
        this.mName = name;
        this.mId = id;
        this.mType = type;
        this.mIsJuicy = isJuicy;
        this.mIsBaseSpirit = isBaseSpirit;
        this.mIsCarbonated = isCarbonated;
        this.mIsAlcoholic = isAlcoholic;
        this.mDescription = description;
    }


    public String getName() {
        return mName;
    }

    public String getId() {
        return mId;
    }

    public String getType() {
        return mType;
    }

    public String getIsJuicy() {
        return mIsJuicy;
    }

    public String getIsBaseSpirit() {
        return mIsBaseSpirit;
    }



    public String getIsCarbonated() {
        return mIsCarbonated;
    }

    public String getIsAlcoholic() {
        return mIsAlcoholic;
    }

    public String getDescription() {
        return mDescription;
    }



}

