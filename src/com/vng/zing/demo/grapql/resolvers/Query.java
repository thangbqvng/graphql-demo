/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.demo.grapql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.vng.zing.demo.grapql.daos.PostDao;
import com.vng.zing.demo.grapql.daos.UserDao;
import com.vng.zing.demo.grapql.entities.Post;
import com.vng.zing.demo.grapql.entities.User;
import java.util.List;

/**
 *
 * @author thangbq
 */
public class Query implements GraphQLQueryResolver {
    private final UserDao userDao;
    private final PostDao postDao;
    
    public Query(UserDao userDao, PostDao postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }
    
    public List<User> allUser(){
        return userDao.list();
    }
    
    public User getUser(long id){
        return userDao.getUser(id);
    }
    
    public List<Post> allPost(){
        return postDao.list();
    }
    
    public Post getPost(long id){
        return postDao.getPost(id);
    }
}
