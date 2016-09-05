/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.model;

import java.util.Date;

/*
 * @author huming
 */
public class UserStatus {
    
    public UserStatus(){
        
    }
    
    /*
     * 针对用户登陆
     */
    public UserStatus(UserLoginInfo loginInfo, String session){
        this._lastUpdateTime = new Date();
        this._loginTime = new Date();
        this._session = session;
        this._userName = loginInfo.getUserName();
    }
    
    private String _userName;
    
    public void setUserName(String userName){
        this._userName = userName;
    }
    
    public String getUserName(){
        return this._userName;
    }
    
    private String _session;
    
    public void setSession(String session){
        this._session = session;
    }
    
    public String getSession(){
        return this._session;
    }
    
    private Date _loginTime;
    
    public void setLoginTime(Date date){
        this._loginTime = date;
    }
    
    public Date getLoginTime(){
        return this._loginTime;
    }
    
    private Date _lastUpdateTime;
    
    public void setLastUpdateTime(Date date){
        this._lastUpdateTime = date;
    }
    
    public Date getLastUpdateTime(){
        return this._lastUpdateTime;
    }
    
}