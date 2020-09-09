package com.example.leaderboard.iq;


import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IqResponse {

    /**
     * {
     * "name": "Perry Oluwatobi",
     * "score": 229,
     * "country": "Nigeria",
     * "badgeUrl": "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
     * },
     */
//    private String name;
//    private int score;
//    private String country;
//    private String bargeUrl;
//
//
//
//
//    public String getName() {
//        return name;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public String getBargeUrl() {
//        return bargeUrl;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public void setBargeUrl(String bargeUrl) {
//        this.bargeUrl = bargeUrl;
//    }
//
//
//
//
//        @Override
//    public String toString() {
//        return "IqResponse{" +
//                "name='" + name + '\'' + ", score=" + score + '\''+", country='" + country + '\'' + ", bargeUrl='" + bargeUrl + '\'' +
//                '}';
//    }


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @Override
    public String toString() {
        return "IqResponse{" +
                "name='" + name + '\'' + ", score=" + score + '\'' + ", country='" + country + '\'' + ", bargeUrl='" + badgeUrl + '\'' +
                '}';

    }
}

