package com.NetCracked.project.gromov.thundersound.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private int id;
    private String nickname;
    private String login;
    private List<String> roles;

    public JwtResponse(String accessToken, int id, String nickname, String login, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.nickname = nickname;
        this.login = login;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getRoles() {
        return roles;
    }
}