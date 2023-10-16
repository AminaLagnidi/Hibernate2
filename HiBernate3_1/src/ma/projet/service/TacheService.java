/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.IDao;
import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class TacheService implements IDao<Tache>{
     public boolean create(Tache o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
 
    public boolean update(Tache o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
 
    public boolean delete(Tache o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }
 
    public Tache findById(int id) {
        Tache projet = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        projet = (Tache) session.get(Tache.class, id);
        session.getTransaction().commit();
        return projet;
    }
 
    public List<Tache> findAll() {
        List<Tache> projets = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        projets = session.createQuery("from Tache").list();
        session.getTransaction().commit();
        return projets;
    }

   
    public Tache getById(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Tache> findBetweenDate(Date date1, Date date2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
    

