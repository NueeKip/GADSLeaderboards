package com.example.leaderboard.learner;

public class LearnerResponse {

    /**
     {
     "name": "Perry Oluwatobi",
     "hours": 229,
     "country": "Nigeria",
     "badgeUrl": "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
     },

     */
    private String name;
    private int hours;
    private String country;
    private String bargeUrl;

    public String getName() {
        return name;
    }

    public int getHours()

    {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBargeUrl() {
        return bargeUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBargeUrl(String bargeUrl) {
        this.bargeUrl = bargeUrl;
    }

    @Override
    public String toString() {
        return "IqResponse{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", country='" + country + '\'' +
                ", bargeUrl='" + bargeUrl + '\'' +
                '}';
    }
}