package com.company.jcc.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class RegUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public RegUser() {
    }

    @Enumerated(EnumType.STRING)
    private ProjectRole role = ProjectRole.ROLE_USER;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    private String password;
    @Override
    public String getPassword() {
        return password;
    }

    @Column(unique = true)
    private String username;
    @Override
    public String getUsername() {
        return username;
    }


    private boolean accNonExp = true;
    @Override
    public boolean isAccountNonExpired() {
        return accNonExp;
    }

    private boolean accNonLock = true;
    @Override
    public boolean isAccountNonLocked() {
        return accNonLock;
    }

    private boolean credsNonExp = true;
    @Override
    public boolean isCredentialsNonExpired() {
        return credsNonExp;
    }

    private boolean enable = true;
    @Override
    public boolean isEnabled() {
        return enable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(ProjectRole role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccNonExp(boolean accNonExp) {
        this.accNonExp = accNonExp;
    }

    public void setAccNonLock(boolean accNonLock) {
        this.accNonLock = accNonLock;
    }

    public void setCredsNonExp(boolean credsNonExp) {
        this.credsNonExp = credsNonExp;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
