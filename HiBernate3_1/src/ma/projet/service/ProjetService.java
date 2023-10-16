/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.IDao;
import ma.projet.classes.Projet;
import ma.projet.util.HibernateUtil;

import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class ProjetService implements IDao<Projet>{
     public boolean create(Projet o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
 
    public boolean update(Projet o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
 
    public boolean delete(Projet o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }
 
    public Projet findById(int id) {
        Projet projet = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        projet = (Projet) session.get(Projet.class, id);
        session.getTransaction().commit();
        return projet;
    }
 
    public List<Projet> findAll() {
        List<Projet> projets = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        projets = session.createQuery("from Projet").list();
        session.getTransaction().commit();
        return projets;
    }

   
    public Projet getById(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Projet> findBetweenDate(Date date1, Date date2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
    

