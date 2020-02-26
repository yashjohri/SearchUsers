package com.example.searchusers;

public class ApiResult {
    private Integer total_count;
    private GithubUser[] items;

    public ApiResult() {
    }

    public ApiResult(Integer total_count, GithubUser[] items) {
        this.total_count = total_count;
        this.items = items;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public GithubUser[] getItems() {
        return items;
    }

    public void setItems(GithubUser[] items) {
        this.items = items;
    }
}
