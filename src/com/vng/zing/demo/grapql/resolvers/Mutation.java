/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.demo.grapql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.vng.zing.demo.grapql.daos.PostDao;
import com.vng.zing.demo.grapql.daos.UserDao;
import com.vng.zing.demo.grapql.entities.Post;
import com.vng.zing.demo.grapql.entities.User;

/**
 *
 * @author thangbq
 */
public class Mutation implements GraphQLMutationResolver {
    private final UserDao userDao;
    private final PostDao postDao;

    public Mutation(UserDao userDao, PostDao postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }
    
    public User createUser(String name, int age){
        return userDao.addUser(new User(userDao.getNewID(),name,age));
    }
    
    public Post newPost(long uid, String title, String content){
        return postDao.addPost(new Post(postDao.getNewID(),uid,title,content));
    }
    
    public Post newPost(long uid, String content){
        return postDao.addPost(new Post(postDao.getNewID(),uid,content));
    }
}
