/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.db.access;

import com.ft.common.LogHelper;
import com.ft.db.mapping.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * @author huming
 * 以下演示如何使用 Hibernate 对数据库进行操作
 */
public class UserAccess extends HibernateUtil {

    /*
     * 添加用户
     */
    public void addUser(User user) {
        Session session = null;

        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            LogHelper.log(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /*
     * 根据User Name 查询用户
     */
    public User getUser(String userName) {
        User user = null;
        Session session = null;

        try {
            session = getSessionFactory().openSession();
            String sql = String.format("from User where user_name='%s'", userName);

            Query query = getSessionFactory().openSession().createQuery(sql);
            user = (User) query.uniqueResult();
        } catch (Exception ex) {
            LogHelper.log(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return user;
    }
    
    /*
     * 获取所有用户
     */
    public List<User> getUsers(){
        Session session = null;
        List<User> users = null;

        try {
            session = getSessionFactory().openSession();
            String sql = "from User";

            Query query = getSessionFactory().openSession().createQuery(sql);
            users = (List<User>)query.list();
        } catch (Exception ex) {
            LogHelper.log(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return users;
    }

    /*
     * 更新用户信息
     */
    public void updateUser(User user) {
        Session session = null;

        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            user.setRemark("test");
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            LogHelper.log(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /*
     * 删除用户
     */     
    public void deleteUser(User user) {
        Session session = null;

        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            User deleteUser =  (User)session.get(User.class, user.getId());
            session.delete(deleteUser);
            session.getTransaction().commit();
        } catch (Exception ex) {
            LogHelper.log(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}