/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.List;
import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.service.DeveloppeurService;
import ma.projet.service.ManagerService;

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String [] args){
  DeveloppeurService dev = new DeveloppeurService() {

            @Override
            public List<Developpeur> findAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        ManagerService man = new ManagerService() {

            @Override
            public List<Manager> findAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        dev.create(new Developpeur("Laili", 2000));
        dev.create(new Developpeur("Lagnidi", 1500));
        
        man.create(new Manager("Boss", 4000));
        
       for (Manager m : man.findAll() ){
          {
            System.out.println("le Manager est : " +m.getNom()+" "+m.getSalaire());
            }
       for (Developpeur d : dev.findAll() )
          {
            System.out.println("le Developpeur est : " +d.getNom()+" "+d.getSalaire());
            }
           
 
}
}

}
