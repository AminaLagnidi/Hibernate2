/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author HP
 */
@Entity
public class Tache  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id ;
    private String nom ;
    private Date dateDEbut ;
     private Date dateFin ;
     private Double prix;

    public Tache() {
    }

    public Tache(String nom, Date dateDEbut, Date dateFin, Double prix) {
        this.nom = nom;
        this.dateDEbut = dateDEbut;
        this.dateFin = dateFin;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDEbut() {
        return dateDEbut;
    }

    public void setDateDEbut(Date dateDEbut) {
        this.dateDEbut = dateDEbut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
     
}
