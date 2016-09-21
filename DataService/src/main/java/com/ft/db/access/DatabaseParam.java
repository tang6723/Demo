/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.db.access;

import java.io.IOException;

/*
 * @author Ming
 */
public class DatabaseParam {
    
    //MySQL Info
    private String mysqlDbHost;
    private String mysqlDb;
    private String mysqlDbUser;
    private String mysqlDbPwd;
    
    private static DatabaseParam _param;
    
    public static DatabaseParam getInstance() throws IOException{
        if (_param == null)
        {
            _param = new DatabaseParam();
        }
        
        return _param;
    }
    
    public String getMySqlDbHost(){
        if (mysqlDbHost == null)
        {
            mysqlDbHost = "127.0.0.1";
        }
        
        return mysqlDbHost;
    }
    
    public String getMySqlDb(){
        if (mysqlDb == null)
        {
            mysqlDb = "test";
        }
        
        return mysqlDb;
    }
    
    public String getMySqlDbUser(){
        if (mysqlDbUser == null)
        {
            mysqlDbUser = "test";
        }
        
        return mysqlDbUser;
    }
        
    public String getMySqlDbPwd(){
        if (mysqlDbPwd == null)
        {
            mysqlDbPwd = "password";
        }
        
        return mysqlDbPwd;
    }
    
}