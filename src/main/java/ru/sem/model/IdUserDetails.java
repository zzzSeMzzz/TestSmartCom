package ru.sem.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Admin on 16.11.2017.
 */
public class IdUserDetails extends org.springframework.security.core.userdetails.User {

    private int userId;

    public int getUserId() {
        return userId;
    }

    public IdUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, int userId) {
        super(username, password, authorities);
        this.userId=userId;
    }
}
