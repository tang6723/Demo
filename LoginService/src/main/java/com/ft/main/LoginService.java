/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.main;

import com.ft.model.LoginResult;
import com.ft.model.UserLoginInfo;
import com.ft.model.UserStatus;
import com.ft.session.Pool;
import java.util.UUID;

/*
 * @author huming
 */
public class LoginService {
    
    public LoginResult login(UserLoginInfo user){
        LoginResult result = new LoginResult();
        
        if ("test".equals(user.getUserName()) && "".equals(user.getPassword()))
        {
            result.setLoginResult(true);
            result.setSession("aabbcc");
            result.setLoginMessage("登录成功");
            
            UserStatus status = new UserStatus(
               user,
               generateSession(user)
            );
            
            Pool.addUserStatus(status);
        }
        else{
            result.setLoginResult(false);
            result.setLoginMessage("登录失败，因为 bla bla 原因导致什么什么样的失败，用这个消息提示用户");
        }
        
        return result;
    }
    
    /*
     * 验证用户状态是否还有效
     * @return True   验证通过
     *                False  验证未通过
     */
    public boolean validateUserStatus(UserStatus status){
        return Pool.existUserStatus(status);
    }
    
    /*
     * todo: 根据用户信息生成 Session
     * 设计一个Session生成算法
     */
    private String generateSession(UserLoginInfo user){
       return UUID.randomUUID().toString();
    }

}