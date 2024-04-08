package com.example.assaigmentjava4.service.impl;

import com.example.assaigmentjava4.config.HibernateUtil;
import com.example.assaigmentjava4.entity.Video;
import com.example.assaigmentjava4.service.VideoService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class VideoServiceImpl implements VideoService {


    @Override
    public List<Video> getAllVideo() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            String hql = "select v from Video v";
            Query<Video> query = session.createQuery(hql, Video.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Video getVideoById(int id) {
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tr = session.beginTransaction();
            String hql = "select v from Video v where v.id = :id";
            Query<Video> query = session.createQuery(hql,Video.class);
            query.setParameter("id",id);
            return query.uniqueResult();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addVideo(Video video) {
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tr = session.beginTransaction();
            session.persist(video);
            tr.commit();
            return 1;
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            return 0;
        }
    }

    @Override
    public int updateVideo(Video video) {
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tr = session.beginTransaction();
            session.merge(video);
            tr.commit();
            return 1;
        }catch (Exception e){
            if (tr != null){
                tr.rollback();
            }
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteVideo(int id) {
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tr = session.beginTransaction();
            Video video = session.get(Video.class,id);
            session.remove(video);
            tr.commit();
            return 1;
        }catch (Exception e)
        {
            if (tr != null){
                tr.rollback();
            }
            e.printStackTrace();
            return 0;
        }

    }
}
