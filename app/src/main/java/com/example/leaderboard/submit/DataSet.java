package com.example.leaderboard.submit;

public class DataSet {
    String name;
    String lastName;
    String email;
    String gitUrl;

    public DataSet(String name, String lastName, String email, String gitUrl) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gitUrl = gitUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }
}
