
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author casper
 */
public class DataBase {
    
    public Connection connection() throws ClassNotFoundException, SQLException{
        Connection connection = null;
        
        try {
            
            String DRIVER = "com.mysql.cj.jdbc.Driver";
            String user = "batman";
            String password = "Password123!";
            String IP = "206.189.57.7";
            String PORT = "3306";
            String DATABASE = "test";
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
                    
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            System.out.println(e);
        }

        return connection;
    }
    
    public Connection localTestConnection () throws ClassNotFoundException, SQLException {
        Connection testConnection = null; 
        
           try {
            
            String DRIVER = "com.mysql.cj.jdbc.Driver";
            String user = "superman";
            String password = "Password123!";
            String IP = "localhost";
            String PORT = "3306";
            String DATABASE = "test";
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
                    
            Class.forName(DRIVER);
            testConnection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            System.out.println(e);
        }

        return testConnection;
    }
    }