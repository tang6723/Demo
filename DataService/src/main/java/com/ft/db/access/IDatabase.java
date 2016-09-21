/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.db.access;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Ming
 */
public interface IDatabase {
    public void createConnection();
    public Connection openConnection();
    public void closeConnection();
    
    public boolean insert(String sql);
    public boolean update(String sql);
    public boolean delete(String sql);
    
    public int count(String sql);
    public ResultSet queryResultSet(String sql);
}