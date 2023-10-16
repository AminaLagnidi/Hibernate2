/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import java.util.Date;
import java.util.List;
import ma.projet.entity.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class ProduitService implements IDao<Produit>{
     public boolean create(Produit o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
 
    public boolean update(Produit o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
 
    public boolean delete(Produit o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }
 
    public Produit findById(int id) {
        Produit produit = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        produit = (Produit) session.get(Produit.class, id);
        session.getTransaction().commit();
        return produit;
    }
 
    public List<Produit> findAll() {
        List<Produit> produits = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        produits = session.createQuery("from Produit").list();
        session.getTransaction().commit();
        return produits;
    }

    @Override
    public Produit getById(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Produit> findBetweenDate(Date date1, Date date2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
