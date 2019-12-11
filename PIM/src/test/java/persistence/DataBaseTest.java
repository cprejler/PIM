package persistence;

import java.sql.SQLException;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class DataBaseTest {

    @Test
    public void connectionTest() throws ClassNotFoundException, SQLException {
        DataBase db = new DataBase();
        ChooseConnection cv = new ChooseConnection();

        cv.chooseConnections();

        //db.connectionValg();
        //assertFalse(db.connection().isClosed());
        assertFalse(cv.chooseConnections().isClosed());
        // assertEquals(cv.getDatabase(),"testpim");
    }
}
