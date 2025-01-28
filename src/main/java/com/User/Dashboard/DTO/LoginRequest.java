package com.User.Dashboard.DTO;


public class LoginRequest {
    String userId;
    String password;

    public LoginRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

}
