/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.IDao;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public abstract class EmployeTacheService implements IDao<EmployeTache>{
 
    public boolean create(EmployeTacheService o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

   
   

    public List<EmployeTache> findAll(){
        List<EmployeTache> EmployeTaches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            EmployeTaches = session.createQuery("from EmployeTacheService").list();
            tx.commit();
            return EmployeTaches;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return EmployeTaches;
        } finally {
            if(session != null)
                session.close();
        }
    }

  @Override
    public EmployeTache getById(int id) {
        EmployeTache EmployeTaches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            EmployeTaches = (EmployeTache) session.get(EmployeTache.class, id);
            tx.commit();
            return EmployeTaches;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return EmployeTaches;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

       
}
