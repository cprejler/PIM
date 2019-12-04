/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author casper
 */
public class ExcelWriterTest {
    
    @Test
    public void createWorkBookTest() throws ClassNotFoundException, SQLException, IOException{
        ExcelWriter excelWriter = new ExcelWriter();
        Workbook workbook = excelWriter.createWorkBook();
        
        
    }
    
}
