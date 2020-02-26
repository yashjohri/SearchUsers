package com.example.searchusers;

public class GithubUser {

    private String login;
    private String html_url;
    private String avatar_url;
    private int score;

    public GithubUser() {
    }

    public GithubUser(String login, String html_url, String avatar_url, int score) {
        this.login = login;
        this.html_url = html_url;
        this.avatar_url = avatar_url;
        this.score = score;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
