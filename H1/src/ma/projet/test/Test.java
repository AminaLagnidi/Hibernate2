/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[] args) {
 
        //Creation des produits
        ProduitService ps = new ProduitService();
        ps.create(new Produit("lala", "aa23", new Date("2023/10/08"), 8520, "Produit laa"));
        //ps.create(new Produit("Ali", "iii23", new Date("01/01/2000"), 1000, "Produit Ali"));
       // ps.create(new Produit("Colgate", "Char86",new Date("2009/09/23"), 600, "Produit Colgate"));
       // ps.create(new Produit("Alag", "tt56",new Date("2019/02/26"), 6000, "Produit Alag"));
        //ps.create(new Produit("rang Rover", "Evoque", new Date("2015/08/02"), 600000, "Produit Range Rover"));
        //Liste des produits
        for (Produit e : ps.findAll()) {
            System.out.println(e.getMarque());
        }
        //Les informations du produit dont id = 2
       // for (Produit p : ps.findAll()) {
         //   if (p.getId() == 2) {
            //   System.out.println(p.getId() + " , " + p.getMarque() + " , " + p.getReference() + " , " + p.getDateAchat() + " , " + p.getPrix() + " , " + p.getDesignation());
           // }
        //}
        //Supprimer le produit dont id = 2
        //ps.delete(ps.findById(2));
        //Modifier les informations du produit dont id = 1,
        //Produit p = ps.findById(1);
       //if (p != null) {
            //p.setMarque("Mercedes");
            //p.setReference("AMG56");
            //p.setDateAchat(new Date("2015/08/02"));
            //p.setPrix(100000);
           // p.setDesignation("Produit  Voiture");
           // ps.update(p);
       // }
        //Afficher la liste des produits dont le prix est supérieur à 100 DH
      //  for (Produit pp : ps.findAll()) {
       //   if (pp.getPrix() > 100) {
       //       System.out.println("" + pp.getMarque());
        //   }
             ProduitService produitService = new ProduitService();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = dateFormat.parse("2023-01-01");
            Date date2 = dateFormat.parse("2023-12-31");

            List<Produit> produits = produitService.findBetweenDate(date1, date2);

            System.out.println("Liste des produits commandés entre " + dateFormat.format(date1) + " et " + dateFormat.format(date2) + ":");
            for (Produit produit : produits) {
                System.out.println("Référence: " + produit.getReference() + ", Prix: " + produit.getPrix() + " DH");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        }
   }

  


