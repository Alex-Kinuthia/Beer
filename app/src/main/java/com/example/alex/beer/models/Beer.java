package com.example.alex.beer.models;

import org.parceler.Parcel;

/**
 * Created by alex on 6/4/17.
 */

public class Beer {
    private String mId;
    private String mName;
    private String mAbv;
    private String mStyleId;
    private String mIsOrganic;
    private String mStatus;
    private String mDescription;
    private String mImageUrl = null;
//    private String mCreateDate;
//    private String mUpdateDate;


    public Beer(String id, String name, String abv,String styleId, String isOrganic, String description, String status) {
       this.mId = id;
        this.mName = name;
        this.mAbv = abv;
        this.mStyleId = styleId;
        this.mIsOrganic = isOrganic;
        this.mStatus = status;
        this.mDescription = description;
//        this.mCreateDate = createDate;

//        this.mUpdateDate = updateDate;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getAbv() {
        return mAbv;
    }

    public String getStyleId() {
        return mStyleId;
    }

    public String getIsOrganic() {
        return mIsOrganic;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

        public String getStatus(){
        return mStatus;
    }

    public String getDescription() {
        return mDescription;
    }



//    public String getCreateDate() {
//        return mCreateDate;
//    }
//
//    public String getUpdateDate() {
//        return mUpdateDate;
//    }

}

