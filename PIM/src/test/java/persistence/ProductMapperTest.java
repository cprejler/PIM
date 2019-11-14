package persistence;

import businesslogic.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        String wineType = "Red";
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
        
        //Product testWine = new Product(fields, "test", "white", "wine", "test");
        
        //pMapper.insertProduct(testWine);
        
    }
    
    @Test
    public void deleteProductTest() throws ClassNotFoundException, SQLException{
        ProductMapper pMapper = new ProductMapper();
    }
    @Test
    public void updateProductTest() throws ClassNotFoundException, SQLException{
        
        ProductMapper pMapper = new ProductMapper();
        ArrayList<Object> fieldsValue = new ArrayList();
        ArrayList<String> fields = new ArrayList();
        int year = 1980;
        String wineType = "Red";
        String wineGrape = "Trepat";
        String wineVolume = "75";
        String wineAlchoholpercentage = "10-12";
        String wineCountry = "portugal";
        String productID = "9";
        
        
        fieldsValue.add(year);
        fieldsValue.add(wineType);
        fieldsValue.add(wineGrape);
        fieldsValue.add(wineVolume);
        fieldsValue.add(wineAlchoholpercentage);
        fieldsValue.add(wineCountry);
        fieldsValue.add(productID);
        fields.add("empty");
        
        Product testWine = new Product("test", "white", "wine", "test", fields, fieldsValue);
        testWine.setID(9);
        testWine.setPublished(Boolean.FALSE);
        ArrayList<Product> productList = new ArrayList();
        productList.add(testWine);
        pMapper.updateProduct(productList);

        
    }
    
    @Test
    public void showProductTest() throws ClassNotFoundException, SQLException {
        ProductMapper pMapper = new ProductMapper();
        String productType = "wine"; 
        HashMap<String, ArrayList<Object>> product = pMapper.showProduct(productType);
        //String columnName = (String); 
        //int columnField = (Integer) ;
        assertFalse(product.get("columnNames").isEmpty());
        
        assertEquals(product.get("columnNames").get(0), "manufacturer"); 
        assertEquals(product.get("columnFields").get(0), "test");
        assertEquals(product.get("columnNames").get(4), "wineType"); 
        //assertEquals(product.get("columnFields").get())
        
    }
}
