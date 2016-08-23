/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.model;

/*
 * @author huming
 */
public class LoginResult {
    
    public boolean _loginResult;
    
    public void setLoginResult(boolean loginResult){
        this._loginResult = loginResult;
    }
    
    public boolean getLoginResult(){
        return _loginResult;
    }
    
    public String _loginMessage;
    
    public void setLoginMessage(String loginMessage){
        this._loginMessage = loginMessage;
    }
    
    public String getLoginMessage(){
        return this._loginMessage;
    }
    
    public String _session;
    
    public void setSession(String session){
        this._session = session;
    }
    
    public String getSession(){
        return this._session;
    }
    
}