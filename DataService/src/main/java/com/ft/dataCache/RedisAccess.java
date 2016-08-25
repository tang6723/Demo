/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.dataCache;

import redis.clients.jedis.*;
import redis.clients.util.*;

/*
 * @author huming
 */
public class RedisAccess {
    
    public RedisAccess(String jedisAddress){
        _jedis = new Jedis(jedisAddress);
    }
    
    private static Jedis _jedis = null;
    
    public static Jedis getRedisJava(){
        return _jedis;
    }
    
    
    
}