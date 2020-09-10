package com.example.leaderboard.learner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LearnerResponse {

    /**
     * {
     * "name": "Perry Oluwatobi",
     * "hours": 229,
     * "country": "Nigeria",
     * "badgeUrl": "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
     * },
     */

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hours")
    @Expose
    private int hours;
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

    public int getHours() {

        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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
                "name='" + name + '\'' +
                ", hours=" + hours +'\'' +
                ", country='" + country + '\'';
    }
}