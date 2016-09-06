/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.session;

import java.util.HashMap;
import com.ft.model.UserStatus;

/**
 *
 * @author Ming
 */
public class Pool {
    
    private static final HashMap<String, UserStatus> SessionPool = new HashMap<>();
    
    /*
     * 验证用户状态是否在Session Pool
     */
    public static boolean existUserStatus(UserStatus status) {
        return getUserStatus(status.getUserName()) == null;
    }

    /*
     * 保存用户Session
     */
    public static void addUserStatus(UserStatus status) {
        SessionPool.put(status.getUserName(), status);
    }

    /*
     * 获取用户状态
     */
    public static UserStatus getUserStatus(String userName) {
        return (UserStatus)SessionPool.get(userName);
    }
    
    /*
     * todo: 清除无效的 Session
     * 1. 读取所有Session，通过处理过期的Session 
     */
    public static void clearInvalidSession(){
        
    }
    
}