package com.example.alex.beer.models;

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
    private String mLabel;
    private String mCreateDate;
    private String mUpdateDate;


    public Beer(String id, String name, String abv,String styleId, String isOrganic, String status, String description, String label, String createDate, String updateDate) {
       this.mId = id;
        this.mName = name;
        this.mLabel = label;
        this.mAbv = abv;
        this.mStyleId = styleId;
        this.mIsOrganic = isOrganic;
        this.mStatus = status;
        this.mDescription = description;
        this.mCreateDate = createDate;
        this.mUpdateDate = updateDate;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getLabel() {
        return mLabel;
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

    public String getStatus(){
        return mStatus;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getCreateDate() {
        return mCreateDate;
    }

    public String getUpdateDate() {
        return mUpdateDate;
    }

}

