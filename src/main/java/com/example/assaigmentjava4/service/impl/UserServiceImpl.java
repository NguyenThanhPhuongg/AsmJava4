package com.example.assaigmentjava4.service.impl;

import com.example.assaigmentjava4.entity.Users;
import com.example.assaigmentjava4.service.UserService;
import com.example.assaigmentjava4.config.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<Users> getAllUsers() {
        List<Users> listUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Users";
            Query<Users> query = session.createQuery(hql, Users.class);
            listUser = query.getResultList();
            return listUser;
        } catch (Exception e) {
            System.out.println("Lỗi query");
            return null;
        }
    }

    @Override
    public Users getUserById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            String hql = "from Users where id = :id";
            Query<Users> query = session.createQuery(hql ,Users.class);
            query.setParameter("id" ,id);
            return query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addUser(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateUser(Users user) {
       Transaction tr = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()){
           tr = session.beginTransaction();
           session.saveOrUpdate(user);
           tr.commit();
           return 1;
       }catch (Exception e){
           if(tr != null){
               tr.rollback();
           }
           return 0;
       }
    }

    @Override
    public int deleteUser(int id) {
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Users usetGet = session.get(Users.class, id);
            if (usetGet != null) {
                tr = session.beginTransaction();
                session.delete(usetGet);
                tr.commit();

            }
            return 1;
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return 0;
        }


    }

    @Override
    public Users checkLogin(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            String hql = "from Users where email = :email" ;
            Query<Users> query = session.createQuery(hql ,Users.class);
            query.setParameter("email" ,email);
            return query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
