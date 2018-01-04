/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.demo.grapql.entities;

/**
 *
 * @author thangbq
 */
public class Post {
    long id;
    long uid;
    String title;
    String content;

    public Post(long id, long uid, String title, String content) {
        this.id = id;
        this.uid = uid;
        this.title = title;
        this.content = content;
    }

    public Post(long id, long uid, String content) {
        this.id = id;
        this.uid = uid;
        this.content = content;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
    
    
}
