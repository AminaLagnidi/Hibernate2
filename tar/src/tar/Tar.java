/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HP
 */
public class Tar {

    public static void addTable() {
    // Informations d'accès à la base de données
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/tar1";
    Connection cn = null;
    Statement st = null;
    try {
        // Etape 1 : Chargement du driver
        Class.forName("com.mysql.jdbc.Driver");

        // Etape 2 : Récupération de la connexion
        cn = DriverManager.getConnection(url, user, password);

        // Etape 3 : Création d'un statement
        st = cn.createStatement();
        String req = "CREATE TABLE DevData (Developpeurs VARCHAR(32), Jour CHAR(11), NbScripts INTEGER)";

        // Etape 4 : Exécution de la requête
        int result = st.executeUpdate(req);
        // Vérification du résultat (0 signifie succès)
        if (result == 0) {
            System.out.println("Table DevData créée avec succès.");
        } else {
            System.out.println("Erreur lors de la création de la table DevData.");
        }
    } catch (SQLException e) {
        System.out.println("Erreur SQL : " + e.getMessage());
    } catch (ClassNotFoundException ex) {
        System.out.println("Impossible de charger le driver");
    } finally {
         try {
            // Etape 5 : Libérer les ressources de la mémoire
                st.close();
                cn.close();
            
        } catch (SQLException ex) {
            System.out.println("Impossible de libérer les ressources");
        }
    }
}
public static void save() {
    // ...
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/tar1";
    Connection cn = null;
    Statement st = null;

    try {
        // Etape 1 : Chargement du driver
        Class.forName("com.mysql.jdbc.Driver");

        // Etape 2 : Récupération de la connexion
        cn = DriverManager.getConnection(url, user, password);

        // Etape 3 : Création d'un statement
        st = cn.createStatement();

        String[] insertStatements = {
            "INSERT INTO DevData VALUES ('ALAMI', 'Lundi', 1)",
            "INSERT INTO DevData VALUES ('WAFI', 'Lundi', 2)",
            "INSERT INTO DevData VALUES ('SALAMI', 'Mardi', 9)",
            "INSERT INTO DevData VALUES ('SAFI', 'Mardi', 2)",
            "INSERT INTO DevData VALUES ('ALAMI', 'Mardi', 2)",
            "INSERT INTO DevData VALUES ('SEBIHI', 'Mercredi', 2)",
            "INSERT INTO DevData VALUES ('WAFI', 'Jeudi', 3)",
            "INSERT INTO DevData VALUES ('ALAOUI', 'Vendredi', 9)",
            "INSERT INTO DevData VALUES ('WAFI', 'Vendredi', 3)",
            "INSERT INTO DevData VALUES ('SEBIHI', 'Vendredi', 4)"
        };

        // Etape 4 : Exécution des instructions SQL du tableau
        for (String statement : insertStatements) {
            st.executeUpdate(statement);
        }
        
        System.out.println("Données insérées avec succès.");
    } catch (SQLException e) {
        System.out.println("Erreur SQL : " + e.getMessage());
    } catch (ClassNotFoundException ex) {
        System.out.println("Impossible de charger le driver");
    } finally {
        try {
            // Etape 5 : Libérer les ressources de la mémoire
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Impossible de libérer les ressources");
        }
    }
}
public static void ExoJDBC() {
//Information d'accès à la base de données
String user = "root";
String password = "";
String url = "jdbc:mysql://localhost/tar1";
Connection cn = null;
Statement st = null;
ResultSet rs = null;
try {
//Etape 1 : Chargement du driver
Class.forName("com.mysql.jdbc.Driver");
//Etape 2 : Récupération de la connexion
cn = (Connection) DriverManager.getConnection(url, user, password);
//Etape 3 : Création d'un statement
st = cn.createStatement();
 // Etape 4 : Demandez à l'utilisateur d'entrer la requête SQL
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez votre requête SQL :");
            String sqlQuery = scanner.nextLine();

            // Etape 5 : Exécution de la requête
            if (sqlQuery.toLowerCase().startsWith("select")) {
                // Requête de type SELECT
                rs = st.executeQuery(sqlQuery);

                // Obtention des métadonnées du ResultSet
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Affichage du nombre de colonnes
                System.out.println("Nombre de colonnes : " + columnCount);

                // Affichage des noms et types de colonnes
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnType = metaData.getColumnTypeName(i);
                    System.out.println("Colonne " + i + ": " + columnName + " (Type: " + columnType + ")");
                }

                // Affichage du contenu de la table ligne par ligne
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getString(i) + "\t");
                    }
                    System.out.println();
                }
            } else {
                // Requête de mise à jour (INSERT, UPDATE, DELETE)
                int rowCount = st.executeUpdate(sqlQuery);
                System.out.println("Nombre de lignes modifiées : " + rowCount);
            }}
       catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
finally  {
try {
//Etape 6 : Libérer les ressources de la mémoire
st.close();
cn.close();
} 
catch (SQLException ex) {
System.out.println("Impossible de libérer les ressources");
}
}}
public static void MAXScripts(){
//Information d'accès à la base de données
String user = "root";
String password = "";
String url = "jdbc:mysql://localhost/tar1";
Connection cn = null;
Statement st = null;
ResultSet rs = null;
try {
//Etape 1 : Chargement du driver
Class.forName("com.mysql.jdbc.Driver");
//Etape 2 : Récupération de la connexion
cn = (Connection) DriverManager.getConnection(url, user, password);
//Etape 3 : Création d'un statement
st = cn.createStatement();
String req = "SELECT Developpeurs, jour, max(NBScripts) from devdata group by jour";
//Etape 4 : Exécution de la requête
rs = st.executeQuery(req);  
//Etape 5 
    //la personne ayant réalisé le nombre maximum de script en une journée
    while (rs.next()) {
            String developer = rs.getString("Developpeurs");
            String day = rs.getString("jour");
            int maxScripts = rs.getInt(3);
            
            System.out.println("Le développeur " + developer + " a réalisé " + maxScripts + " scripts le jour " + day); 
    }
           
}       catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
finally  {
try {
//Etape 6 : Libérer les ressources de la mémoire
st.close();
cn.close();
} 
catch (SQLException ex) {
System.out.println("Impossible de libérer les ressources");
}
}

}
public static void TRiCroissant() {
//Information d'accès à la base de données
String user = "root";
String password = "";
String url = "jdbc:mysql://localhost/tar1";
Connection cn = null;
Statement st = null;
ResultSet rs = null;
try {
//Etape 1 : Chargement du driver
Class.forName("com.mysql.jdbc.Driver");
//Etape 2 : Récupération de la connexion
cn = (Connection) DriverManager.getConnection(url, user, password);
//Etape 3 : Création d'un statement
st = cn.createStatement();
String req = "SELECT Developpeurs, jour, sum(NBScripts) as c from devdata group by Developpeurs order by c desc";

//Etape 4 : Exécution de la requête
rs = st.executeQuery(req);

//Etape 5 : 
    //la liste des personnes triée dans l’ordre décroissant selon leur nombre de scripts
    while (rs.next()) {
          String developpeur = rs.getString("Developpeurs");
            int c = rs.getInt("c");
            System.out.println("Nombre total de scripts réalisés par " + developpeur + ": " + c);
        }
    }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
finally  {
try {
//Etape 6 : Libérer les ressources de la mémoire
st.close();
cn.close();
} 
catch (SQLException ex) {
System.out.println("Impossible de libérer les ressources");
}
}
}
public static void NBTotal(){
//Information d'accès à la base de données
String user = "root";
String password = "";
String url = "jdbc:mysql://localhost/tar1";
Connection cn = null;
Statement st = null;
ResultSet rs = null;
try {
//Etape 1 : Chargement du driver
Class.forName("com.mysql.jdbc.Driver");
//Etape 2 : Récupération de la connexion
cn = (Connection) DriverManager.getConnection(url, user, password);
//Etape 3 : Création d'un statement
st = cn.createStatement();
String req = "SELECT Jour, sum(NBScripts) as TotalScripts FROM devdata GROUP BY Jour";
//Etape 4 : Exécution de la requête
rs = st.executeQuery(req);

//Etape 5 : calculer et afficher le nombre total de s cripts réalisés en une semaine.
    
    while (rs.next()) {
        String jour = rs.getString("Jour");
   int totalScripts = rs.getInt("TotalScripts");
    System.out.println("Nombre total de scripts réalisés le " + jour + ": " + totalScripts);  
        }
    }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }

finally  {
try {
//Etape 6 : Libérer les ressources de la mémoire
st.close();
cn.close();
} 
catch (SQLException ex) {
System.out.println("Impossible de libérer les ressources");
}
} }
public static void NBScripts(String nomProgrammeur) {
//Information d'accès à la base de données
String user = "root";
String password = "";
String url = "jdbc:mysql://localhost/tar1";
Connection cn = null;
Statement st = null;
ResultSet rs = null;
try {
//Etape 1 : Chargement du driver
Class.forName("com.mysql.jdbc.Driver");
//Etape 2 : Récupération de la connexion
cn = (Connection) DriverManager.getConnection(url, user, password);
//Etape 3 : Création d'un statement
st = cn.createStatement();

String req = "SELECT Developpeurs, SUM(NBScripts) as TotalScripts FROM devdata WHERE Developpeurs = '" + nomProgrammeur + "'";

//Etape 4 : Exécution de la requête
rs = st.executeQuery(req);

//Etape 5 : calculer pour un programmeur donné le nombre total de scripts réalisés
    
    while (rs.next()) {
        String developpeur = rs.getString("Developpeurs");
            int totalScripts = rs.getInt("TotalScripts");
         System.out.println("Nombre total de scripts réalisés par " + developpeur + ": " + totalScripts);
  
        }
    }
         
       catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
finally  {
try {
//Etape 6 : Libérer les ressources de la mémoire
st.close();
cn.close();
} 
catch (SQLException ex) {
System.out.println("Impossible de libérer les ressources");
}
}

}
public static void main(String[] args)  {
    //addTable();
    //save();
    //MAXScripts();
    //TRiCroissant();
    //NBTotal();
    //NBScripts("WAFI");
   //ExoJDBC();
} 
}
