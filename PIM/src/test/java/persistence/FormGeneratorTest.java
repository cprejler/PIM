/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import presentation.Form;

/**
 *
 * @author casper
 */
public class FormGeneratorTest {
    
    
    //@Test
    public void generateFormTest() throws ClassNotFoundException, SQLException{
        FormGenerator fg = new FormGenerator();
        
        ArrayList<Form> wineForms = fg.generateForm("wine");
        
        assertTrue(wineForms.get(0).getName().equals("productYear"));
        assertTrue(wineForms.get(0).getName().equals("wineType"));
        
        
        
        
        
        
        
        
        
    }
}
