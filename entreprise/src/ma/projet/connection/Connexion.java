/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.connection;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 *
 * @author HP
 */
public class Connexion {
   private static Connexion connection;
static {
try {
FileInputStream f = new FileInputStream("base.properties");
Properties p = new Properties();
p.load(f);
String url = p.getProperty("jdbc.url");
String login = p.getProperty("jdbc.username");
String password = p.getProperty("jdbc.password");
String driver = p.getProperty("jdbc.driver");
Class.forName(driver);
connection = (Connexion) DriverManager.getConnection(url, login, password);
} catch (Exception ex) {
System.out.println(""+ex.getMessage());
}
}
public static Connexion getConnection() {
return connection;
} 

    public PreparedStatement prepareStatement(String req) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
