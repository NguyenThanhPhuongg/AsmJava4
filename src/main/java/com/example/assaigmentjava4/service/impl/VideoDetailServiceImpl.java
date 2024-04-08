package com.example.assaigmentjava4.service.impl;

import com.example.assaigmentjava4.config.HibernateUtil;
import com.example.assaigmentjava4.entity.Video;
import com.example.assaigmentjava4.service.VideoDetailService;
import org.hibernate.Session;

import java.util.List;

public class VideoDetailServiceImpl implements VideoDetailService {
    @Override
    public List<Video> getAllVideoExitClick(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             session.beginTransaction();
             String hql = "SELECT u FROM Video u WHERE u.id <> :id";
             List<Video> list = session.createQuery(hql, Video.class).setParameter("id", id).getResultList();
             return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
