/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.dataCache;

import redis.clients.jedis.*;

/*
 * @author huming
 */
public class Cache {
    
    public Cache(){
       
    }
    
    private static Jedis _jedis = null;
    
    public static Jedis getRedis(){
        if (_jedis == null){
            initRedis("localhost");
        }
        
        return _jedis;
    }
    
    private static void initRedis(String jedisAddress){
        if (_jedis == null){
            _jedis = new Jedis(jedisAddress);
        }
    }
}