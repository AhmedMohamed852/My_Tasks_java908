package com.user.model;

public class UserAcount {
    private long id;
    private String username;
    private String userpass;

    public UserAcount() {}
    
    public UserAcount(String username) {
    	this.username = username;
    }

    // Constructor كامل
    public UserAcount(long id, String username, String userpass) {
        this.id = id;
        this.username = username;
        this.userpass = userpass;
    }

    // Constructor بدون id
    public UserAcount(String username, String userpass) {
        this.username = username;
        this.userpass = userpass;
    }

    // getters & setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getUserpass() { return userpass; }
    public void setUserpass(String userpass) { this.userpass = userpass; }
}
