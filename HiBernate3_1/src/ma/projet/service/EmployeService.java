/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.IDao;
import ma.projet.classes.Employe;
import static ma.projet.classes.EmployeTachePK_.employe;
import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class EmployeService implements IDao<Employe>{
     public boolean create(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
 
    public boolean update(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
 
    public boolean delete(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }
 
    public Employe findById(int id) {
        Employe employe = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employe = (Employe) session.get(Employe.class, id);
        session.getTransaction().commit();
        return employe;
    }
 
    public List<Employe> findAll() {
        List<Employe> employes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes = session.createQuery("from Employe").list();
        session.getTransaction().commit();
        return employes;
    }

   
    public Employe getById(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Employe> findBetweenDate(Date date1, Date date2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
     public List<Tache> getTasksPerformedByEmployee(Employe employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<Tache> query = session.createQuery("SELECT t FROM Tache t JOIN t.employes e WHERE e = :employe", Tache.class);
        query.setParameter("employe", employe);
        List<Tache> tasks = query.list();

        session.getTransaction().commit();
        session.close();

        return tasks;
}}

   