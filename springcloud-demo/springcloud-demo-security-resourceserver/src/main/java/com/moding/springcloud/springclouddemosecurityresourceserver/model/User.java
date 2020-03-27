package com.moding.springcloud.springclouddemosecurityresourceserver.model;

/**
 * @author
 * @create 2018-02-19 22:27
 **/
public class User {

    private String id;
    private String name;

    public User() {

    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}