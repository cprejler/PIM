package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public class ChooseConnection {

    String Database;

    public Connection chooseConnections() throws ClassNotFoundException, SQLException {
        DataBase db = new DataBase();
        Connection connection;
        connection = null;
        /*
        udfyld databasevalg baseret på den server du vil arbejde på 
        1 = Caspers droplet database ved navn "test"
        2 = Din lokale database på computeren ved navn "testpim"
        3 = Vores live-produktions database ved navn "pim"
         */
        int databasevalg = 3;

        switch (databasevalg) {
            case 1:
                connection = db.dropletTestDB();
                setDatabase("testpim");
                break;
            case 2:
                connection = db.localTestDB();
                setDatabase("testpim");
                break;
            case 3:
                connection = db.productionDB();
                setDatabase("PIM");
                break;
            default:
                break;
        }

        return connection;

    }

    public String getDatabase() {
        return Database;
    }

    public void setDatabase(String Database) {
        this.Database = Database;
    }

}
