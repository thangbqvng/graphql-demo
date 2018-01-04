/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.demo.grapql.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thangbq
 */
public class User {
    long id;
    String name;
    int age;
    List<Post> posts;

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.posts = new ArrayList<Post>();
    }

    public User(long id, String name, int age, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.posts = posts;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Post> getPosts() {
        return posts;
    }
    
    public List<Post> getPosts(int limit, int offset) {
        if (offset > posts.size()) {
            return Collections.EMPTY_LIST;
        }
        
        if (offset + limit > posts.size()) {
            return posts.subList(offset, posts.size());
        }
        
        return posts.subList(offset, limit + offset);
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
