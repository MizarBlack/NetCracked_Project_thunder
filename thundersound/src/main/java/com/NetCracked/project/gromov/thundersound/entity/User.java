package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "nickname"),
                @UniqueConstraint(columnNames = "login")
        })
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotBlank
    @Column(name = "nickname")
    private String nickname;
    @NotBlank
    @Column(name = "login")
    private String login;
    @NotBlank
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String nickname, String login, String password) {
        this.nickname = nickname;
        this.login = login;
        this.password = password;
    }
    public User(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
