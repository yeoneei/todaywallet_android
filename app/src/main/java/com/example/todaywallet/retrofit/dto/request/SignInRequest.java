package com.example.todaywallet.retrofit.dto.request;

public class SignInRequest {

    private String email;
    private String pw;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPwo(String pw) {
        this.pw = pw;
    }
}
