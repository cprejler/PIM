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
        ArrayList<Object> fieldValues = new ArrayList();
        int year = 1970;
        String wineType = "Red";
        String wineGrape = "Trepat";
        String wineVolume = "75";
        String wineAlchoholpercentage = "10-12";
        String wineCountry = "France";
        
        fieldValues.add(year);
        fieldValues.add(wineType);
        fieldValues.add(wineGrape);
        fieldValues.add(wineVolume);
        fieldValues.add(wineAlchoholpercentage);
        fieldValues.add(wineCountry);
        ArrayList<String> fields = new ArrayList<>();
        
        //Product testWine = new Product(fields, "test", "white", "wine", "test");
        Product testWine = new Product("test", "test", "wine", "test", fields, fieldValues);
        
        pMapper.insertProduct(testWine);
        
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
    public void showProductsTest() throws ClassNotFoundException, SQLException{
        ProductMapper pMapper= new ProductMapper();
        String productType  = "wine";
        ArrayList<Product>  products = pMapper.showProducts(productType);
        
        assertEquals("manufacturer",  products.get(0).getFields().get(0));
        assertEquals("productID",  products.get(0).getFields().get(9));
        assertEquals(1980, products.get(0).getFieldsValues().get(3));
        assertEquals("France", products.get(2).getFieldsValues().get(8));
        
        
        
        
    }
}
