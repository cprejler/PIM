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

/**
 *
 * @author casper
 */
public class FormGeneratorTest {
    
    
    @Test
    public void generateFormTest() throws ClassNotFoundException, SQLException{
        FormGenerator fg = new FormGenerator();
        
        ArrayList<HashMap<String, Object>> wineForms = fg.generateForm("wine");
        
        assertTrue(wineForms.get(0).get("name").equals("productYear"));
        assertTrue(wineForms.get(1).get("name").equals("wineType"));
        
        ArrayList<String>  options =  (ArrayList<String>)wineForms.get(1).get("options");
        assertTrue(options.get(0).equals("Red"));
        assertTrue(options.get(5).equals("Sparkling"));
        
        ArrayList<HashMap<String,Object>>  phoneForms = fg.generateForm("phone");
        
        assertTrue(phoneForms.get(0).get("name").equals("brand"));
        
        ArrayList<String> operatingSystem = (ArrayList<String>)phoneForms.get(1).get("options");
        
        assertTrue(operatingSystem.get(0).equals("IOS"));
        
        
        
    }
}
