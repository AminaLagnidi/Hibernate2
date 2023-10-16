/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.sql.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;

/**
 *
 * @author HP
 */
public class Messagerie {
  public static void main(String[] args) {
      EmployeService es = new EmployeService();
//Création des employes
es.create(new Employe("Lagnidi", "Amina"));
es.create(new Employe("bb", "Aa"));
es.create(new Employe("dd", "tf"));
 
//Modification d'un employe
Employe e = es.getById(3);
if (e != null) {
 e.setNom("Alami");
 e.setPrenom("Mehdi");
 es.update(e);
}
 
//Suppression d'un employe
//es.delete(es.getById(1));
 
//Liste des employes
for(Employe emp : es.getAll())
 System.out.println(""+emp.getNom());
//test message

MessageService ms = new MessageService();
ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(2023-05-12), es.getById(1), es.getById(2)));
ms.create(new Message("Stage", "Stage à Marrakech",  new Date(2023-05-16), es.getById(2), es.getById(1)));
//Les message reçus par l'employé 3
for (Message m : ms.getAll()) {
 if(m.getEmpRecepteur().getId() == 3)
 System.out.println(""+m.getSujet());
}
  
  }}
