package com.example.alex.beer;

/**
 * Created by alex on 6/4/17.
 */

public class Beer {
    private String mId;
    private String mName;
    private String mDescription;
    private String mAbv;
    private String mStyleId;
    private String mIsOrganic;
    private String mStatus;


    public Beer(String id, String name, String description, String abv,
                       String styleId, String isOrganic, String status) {
       this.mId = id;
        this.mName = name;
        this.mDescription = description;
        this.mAbv = abv;
        this.mStyleId = styleId;
        this.mIsOrganic = isOrganic;
        this.mStatus = status;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAbv() {
        return mAbv;
    }

    public String getStyleId() {
        return mStyleId;
    }

    public String getIsOrganic(){
        return mIsOrganic;
    }

    public String getStatus(){
        return mStatus;
    }
}

