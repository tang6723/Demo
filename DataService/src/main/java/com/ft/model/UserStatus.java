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
    
}