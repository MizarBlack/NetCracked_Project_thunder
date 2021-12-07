package com.NetCracked.project.gromov.thundersound.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
    @NotBlank
    private String nickname;

    @NotBlank
    private String login;

    private Set<String> role;

    @NotBlank
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}