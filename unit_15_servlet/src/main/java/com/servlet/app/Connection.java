package com.servlet.app;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Connection {
    @Id
    @GeneratedValue
    private Long id;
    private String userAgent;
    private String userHost;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserHost() {
        return userHost;
    }

    public void setUserHost(String name) {
        this.userHost = name;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String agent) {
        this.userAgent = agent;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "userHost='" + userHost + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
