package persistence;

import businesslogic.Product;
import static com.sun.tools.javac.tree.TreeInfo.name;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author casper
 */
public class ProductMapperTest {
    
    @Test
    public void insertProductTest() throws ClassNotFoundException, SQLException{
        
        
        ProductMapper pMapper = new ProductMapper();
        ArrayList<Object> fields = new ArrayList();
        int year = 1970;
        String wineType = "White";
        String wineGrape = "Trepat";
        String wineVolume = "75";
        String wineAlchoholpercentage = "10-12";
        String wineCountry = "France";
        
        
        fields.add(year);
        fields.add(wineType);
        fields.add(wineGrape);
        fields.add(wineVolume);
        fields.add(wineAlchoholpercentage);
        fields.add(wineCountry);
                
        
        
        
        Product testWine = new Product(fields, "test", 0, "white", "wine", "test");
        
        pMapper.insertProduct(testWine);
        
        
        
        
    }
    
}
