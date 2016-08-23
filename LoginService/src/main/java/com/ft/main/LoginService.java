/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.main;

import com.ft.model.LoginResult;
import com.ft.model.UserLoginInfo;

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
        }
        else{
            result.setLoginResult(false);
            result.setLoginMessage("登录失败，因为 bla bla 原因导致什么什么样的失败，用这个消息提示用户");
        }
        
        return result;
    }
    
}