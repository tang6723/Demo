/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.model;

/**
 *
 * @author huming
 */
public class UserLoginInfo {
    
    private String _userName;
    
    public void setUserName(String userName){
        this._userName = userName;
    }
    
    public String getUserName(){
        return this._userName;
    }
    
    private String _password;
    
    public void setPassword(String password){
        this._password = password;
    }
    
    public String getPassword(){
        return this._password;
    }
    
}