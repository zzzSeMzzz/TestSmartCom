package ru.sem.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Admin on 16.11.2017.
 */
public class IdUserDetails extends org.springframework.security.core.userdetails.User {

    private int userId;

    private int customerId;

    private Role role;

    public int getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }

    public int getCustomerId() {
        return customerId;
    }

    public IdUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, int userId,
                         int customerId) {
        super(username, password, authorities);
        this.userId=userId;
        String roleS = authorities.stream().findFirst().get().getAuthority();
        role=Role.valueOf(roleS);
        this.customerId=customerId;
    }
}
