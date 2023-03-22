package com.hashigo.Response;

public class LoginResponse {
    private String token;
    private String emailId;
    private String role;

    public LoginResponse(String token, String emailId, String role) {
        this.token = token;
        this.emailId = emailId;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

