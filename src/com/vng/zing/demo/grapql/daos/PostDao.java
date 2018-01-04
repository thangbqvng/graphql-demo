/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.demo.grapql.daos;

import com.vng.zing.demo.grapql.entities.Post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thangbq
 */
public class PostDao {
    private final Map<Long, Post> posts;

    public PostDao() {
        posts = new HashMap<Long, Post>();
        posts.put(1L, new Post(1L,123L,"first post", "this is my first post"));
        posts.put(2L, new Post(2L,321L,"test posts", "1 2 3 check check check"));
        posts.put(3L, new Post(3L,321L,"second test post", "check again and finish"));
        posts.put(4L, new Post(4L,123L,"cheerful", "be happy!!!"));
    }
    
    public List<Post> list(){
        return new ArrayList<Post>(posts.values());
    }
    
    public Post getPost(long id){
        return posts.get(id);
    }
    
    public Post addPost(Post post){
        posts.put(post.getId(), post);
        return post;
    }
    
    public long getNewID(){
        return posts.size() + System.currentTimeMillis();
    }
}
