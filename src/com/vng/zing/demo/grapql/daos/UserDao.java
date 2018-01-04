/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.demo.grapql.daos;

import com.vng.zing.demo.grapql.entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thangbq
 */
public class UserDao {
    private final Map<Long, User> users;

    public UserDao() {
        users = new HashMap<Long,User>();
        
        users.put(123L , new User(123L, "Bùi Quang Thắng", 21));
        users.put(321L, new User(321L, "Lê Thạch", 21));
        users.put(5168489L, new User(5168489L, "Cao Hùng Vĩ", 21));
        users.put(122453233L, new User(122453233L, "Hoài", 21));
        
    }
    
    public List<User> list(){
        return new ArrayList<User>(users.values());
    }
    
    public User getUser(long id){
        return users.get(id);
    }
    
    public User addUser(User user){
        users.put(user.getId(), user);
        return user;
    }
    
    public long getNewID(){
        return users.size() + System.currentTimeMillis();
    }
}
