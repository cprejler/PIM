package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import presentation.Form;

public class FormGeneratorTest {

    @Test
    public void generateFormTest() throws ClassNotFoundException, SQLException {
        FormGenerator fg = new FormGenerator();

        ArrayList<Form> wineForms = fg.generateForm("wine");

        assertTrue(wineForms.get(0).getName().equals("productYear"));
        assertTrue(wineForms.get(0).getInputType().equals("number"));
    }
}
