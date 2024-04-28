package net.javaguides.todo.security;

import org.springframework.security.core.userdetails.UserDetails;

public class APIUserDetails extends org.springframework.security.core.userdetails.User {
    private Long id;

    public APIUserDetails(UserDetails userDetails) {
        super(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
