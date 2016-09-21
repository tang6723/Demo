/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.db.access;

import java.io.IOException;
import java.sql.*;

/*
 * @author Ming
 */
public class MySQL implements IDatabase{
    private final String drive = "com.mysql.jdbc.Driver";
    private String host;
    private String url;
    private String db;
    private String user;
    private String password;
    private Connection conn = null;
    private Statement statement = null;

    /* 
     *  实例化一个 MYSQL 对象，使用内置的数据库参数
     */
    public MySQL() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this(DatabaseParam.getInstance().getMySqlDbHost(), DatabaseParam.getInstance().getMySqlDb(), DatabaseParam.getInstance().getMySqlDbUser(), DatabaseParam.getInstance().getMySqlDbPwd());
    }

    /* 
     *  实例化一个 MYSQL 对象
     */
    public MySQL(String host, String db, String user, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.host = host;
        this.db = db;
        this.user = user;
        this.password = password;

        this.url = String.format("jdbc:mysql://%s:3306/%s?characterEncoding=utf8", this.host, this.db);
        Class.forName(drive).newInstance();
    }

    /*
     * 创建一个数据库连接对象
     */
    @Override
    public void createConnection() {
        if (conn != null) {
            return;
        }

        try {
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            conn.setAutoCommit(true);
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("MySQL 创建数据连接失败，错误信息：" + ex.getMessage());
        }
    }

    /*
     * 创建并返回一个数据库连接对象
     * @return Connection
     */
    @Override
    public Connection openConnection() {
        this.createConnection();
        return conn;
    }

    /*
     * 关闭数据库连接  
     */
    @Override
    public void closeConnection() {
        try {
            this.closeStatement();

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            if (conn != null) {
                conn = null;
            }
        } catch (SQLException ex) {
            System.out.println("MySQL 断开数据连接失败，错误信息：" + ex.getMessage());
        }
    }

    /*
     *  创建Statement
     */
    public Statement createStatement() throws SQLException {
        if (statement == null) {
            if (this.conn != null) {
                statement = conn.createStatement();
            }
        }

        return this.statement;
    }

    /*
     * 关闭Statement
     */
    public void closeStatement() {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (statement != null) {
                statement = null;
            }
        } catch (SQLException ex) {
            System.out.println("MySQL 关闭Statement失败，错误信息：" + ex.getMessage());
        }
    }

    /*
     * 添加数据
     */
    @Override
    public boolean insert(String sql) {
        return execute(sql);
    }

    /*
     * 更新数据
     */
    @Override
    public boolean update(String sql) {
        return execute(sql);
    }

    /*
     * 删除数据
     */
    @Override
    public boolean delete(String sql) {
        return execute(sql);
    }

    /*
     * 执行一个SQL查询，获取数据结果行数
     */
    @Override
    public int count(String sql) {
        int result = 0;

        try {
            this.createConnection();

            try (ResultSet resultSet = createStatement().executeQuery(sql)) {
                resultSet.last();
                result = resultSet.getRow();
            }
        } catch (Exception e) {
            System.out.println("MySQL 执行SQL语句失败，SQL = " + sql + ";  错误信息：" + e.getMessage());
        }

        return result;
    }

    /*
     *  执行一个SQL查询
     *  注意一定要在上层调用的时候，主动调用closeConnection()来关闭连接
     */
    @Override
    public ResultSet queryResultSet(String sql) {
        ResultSet resultSet = null;

        try {
            this.createConnection();
            resultSet = createStatement().executeQuery(sql);
        } catch (Exception e) {
            System.out.println("MySQL 执行SQL语句失败，SQL = " + sql + ";  错误信息：" + e.getMessage());
        }

        return resultSet;
    }

    /*
     * 执行一个SQL进行添加，更新，删除
     */
    private boolean execute(String sql) {
        int affectRowCount = 0;

        try {
            this.createConnection();
            affectRowCount = createStatement().executeUpdate(sql);
            System.out.println("操作成功，所影响的记录数为：" + String.valueOf(affectRowCount));
        } catch (Exception e) {
            System.out.println("MySQL 执行SQL语句失败，SQL = " + sql + ";  错误信息：" + e.getMessage());
        } finally {
            this.closeConnection();
        }

        return affectRowCount > 0;
    }
}