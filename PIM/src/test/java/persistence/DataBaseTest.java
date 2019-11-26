/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author casper
 */
public class DataBaseTest {
    
    
    @Test
    public void connectionTest() throws ClassNotFoundException, SQLException{
        DataBase db = new DataBase();
        ChooseConnection cv = new ChooseConnection();
        
        
        cv.chooseConnections();
        
        
        //db.connectionValg();
        
       // assertFalse(db.connection().isClosed());
       // assertFalse(cv.chooseConnections().isClosed());
       // assertEquals(cv.getDatabase(),"testpim");
        
        
    }
    
    
}
