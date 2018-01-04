/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.demo.grapql.controller;

import com.coxautodev.graphql.tools.SchemaParser;
import com.vng.zing.demo.grapql.daos.PostDao;
import com.vng.zing.demo.grapql.daos.UserDao;
import com.vng.zing.demo.grapql.resolvers.Mutation;
import com.vng.zing.demo.grapql.resolvers.Query;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

/**
 *
 * @author thangbq
 */
public class GraphQLEndpoint extends SimpleGraphQLServlet {
    
    public GraphQLEndpoint() {
        
        super(buildSchema());
    }
    
    private static GraphQLSchema buildSchema() {
        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();
        
        userDao.getUser(123L).getPosts().add(postDao.getPost(1L));
        userDao.getUser(123L).getPosts().add(postDao.getPost(4L));
        
        userDao.getUser(321L).getPosts().add(postDao.getPost(2L));
        userDao.getUser(321L).getPosts().add(postDao.getPost(3L));
        
        return SchemaParser.newParser()
                .file("schema.graphqls") //parse the schema file created earlier
                .resolvers(new Query(userDao, postDao), new Mutation(userDao, postDao))
                .build()
                .makeExecutableSchema();
    }
    
}
