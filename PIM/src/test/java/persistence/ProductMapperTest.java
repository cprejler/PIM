package persistence;

import businesslogic.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author casper
 */
public class ProductMapperTest {

   /* @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        DataBase db = new DataBase();
        
        //db.connection();
        //Connection connection = db.connection();
        
        //db.connectionValg(); 
        Connection connection = db.connectionValg();

        Statement st = connection.createStatement();

        st.executeUpdate("drop table if exists phone;");
        st.executeUpdate("drop table if exists wine;");
        st.executeUpdate("drop table if exists toiletpaper;");
        st.executeUpdate("drop table if exists product;"); 
        
        st.executeUpdate("create table product like producttest;");
        st.executeUpdate("insert into product select * from producttest;");

        st.executeUpdate("create table phone like phonetest;");
        st.executeUpdate("insert into phone select * from phonetest;");

        st.executeUpdate("create table wine like winetest;");
        st.executeUpdate("insert into wine select * from winetest;");
        
      //  st.executeUpdate("create table toiletPaper like toiletPapertest;");
      //  st.executeUpdate("insert into toiletPaper select * from toiletPapertest;");

        connection.close();
    }*/

    @Test
    public void insertProductTest() throws ClassNotFoundException, SQLException {

        ProductMapper pMapper = new ProductMapper();

        ArrayList<String> fields = new ArrayList();

        ArrayList<Object> fieldValues = new ArrayList();
        int year = 1970;
        String manufacturer = "test";
        String productName = "Chardonnay";
        String productType = "Wine";
        String productYear = "1960";
        String wineType = "Red";
        String wineGrape = "Trepat";
        String wineVolume = "75";
        String wineAlchoholpercentage = "10-12";
        String wineCountry = "France";

        fieldValues.add(productYear);
        fieldValues.add(wineType);
        fieldValues.add(wineGrape);
        fieldValues.add(wineVolume);
        fieldValues.add(wineAlchoholpercentage);
        fieldValues.add(wineCountry);

        Product testWine = new Product("test", "test", "wine", "test", fields, fieldValues);

        //pMapper.insertProduct(testWine);
    }

//   @Test
//    public void deleteProductTest() throws ClassNotFoundException, SQLException{
//        ProductMapper pMapper = new ProductMapper();
//        ArrayList<String>  fields = new ArrayList();
//        
//        ArrayList<Object> fieldValues = new ArrayList();
//        int year = 1970;
//        String manufacturer = "test";
//        String productName = "Chardonnay";
//        String productType = "Wine";
//        String productYear = "1960";
//        String wineType = "Red";
//        String wineGrape = "Trepat";
//        String wineVolume = "75";
//        String wineAlchoholpercentage = "10-12";
//        String wineCountry = "France";
//        
//        
//        fieldValues.add(productYear);
//        fieldValues.add(wineType);
//        fieldValues.add(wineGrape);
//        fieldValues.add(wineVolume);
//        fieldValues.add(wineAlchoholpercentage);
//        fieldValues.add(wineCountry);
//        
//        
//        
//        Product testWine = new Product("test", "test", "wine", "test", fields, fieldValues);
//        
//        pMapper.deleteProduct(testWine);
//    }
    @Test
    public void updateProductTest() throws ClassNotFoundException, SQLException {

        ProductMapper pMapper = new ProductMapper();
        ArrayList<Object> fieldsValue = new ArrayList();
        ArrayList<String> fields = new ArrayList();
        int year = 1980;
        String wineType = "Red";
        String wineGrape = "Trepat";
        String wineVolume = "75";
        String wineAlchoholpercentage = "10-12";
        String wineCountry = "poland";
        String productID = "8";

        fieldsValue.add(year);
        fieldsValue.add(wineType);
        fieldsValue.add(wineGrape);
        fieldsValue.add(wineVolume);
        fieldsValue.add(wineAlchoholpercentage);
        fieldsValue.add(wineCountry);
        fieldsValue.add(productID);
        fields.add("empty");

        Product testWine = new Product("test1", "white", "wine", "test", fields, fieldsValue);
        testWine.setID(8);
        testWine.setPublished(Boolean.FALSE);
        ArrayList<Product> productList = new ArrayList();
        productList.add(testWine);
        pMapper.updateProduct(productList);

    }

    @Test
    public void showProductsTest() throws ClassNotFoundException, SQLException {
//        ProductMapper pMapper = new ProductMapper();
//
//        ArrayList<Product> wine = pMapper.showProducts("wine");
//        ArrayList<Product> phone = pMapper.showProducts("phone");
//
//        assertEquals("manufacturer", wine.get(0).getFields().get(0));
//        assertEquals("productID", wine.get(0).getFields().get(9));
//        //assertEquals(1960, wine.get(0).getFieldsValues().get(3));
//        assertEquals("portugal", wine.get(2).getFieldsValues().get(8));
//        assertEquals("grape", wine.get(5).getFields().get(5));
//
//        assertEquals("manufacturer", phone.get(0).getFields().get(0));
//        assertEquals("Apple", phone.get(0).getFieldsValues().get(0));

    }

    @Test
    public void alterEnumTest() throws ClassNotFoundException, SQLException {

        ProductMapper pMapper = new ProductMapper();
        String product = "toiletpaper";

        String pro2 = pMapper.alterProductTypeEnum(product);
    }
/*
    @Test
    public void createProductTableTest() throws ClassNotFoundException, SQLException {
        DataBase db = new DataBase();
        db.connection();
        Connection connection = db.connection();

        Statement st = connection.createStatement();
        String dropToiletPaper = "Drop table if exists toiletPaper";
        st.executeUpdate(dropToiletPaper);
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> vars = new ArrayList();
        ArrayList<String> enums = new ArrayList();

        String product = "toiletPaper";
        String Sproducent = "Sproducent";
        String Eantallag = "EAntallag";
        String FMeter = "FMeter";
        String EAntalRuller = "EAntalRuller";

        vars.add(product);
        vars.add(Eantallag);
        vars.add(FMeter);
        vars.add(EAntalRuller);

        String EnumsAntalRuller = "'2', '4', '6'";
        String EnumsAntalLag = "'1', '2', '3', '4'";
        enums.add(EnumsAntalRuller);
        enums.add(EnumsAntalLag);

        String query = pMapper.createProductTable(vars, enums);
        StringBuilder sb = new StringBuilder(query);

        assertEquals(product, sb.subSequence(13, 24));

    }
*/
    @Test
    public void getTableNames() throws SQLException, ClassNotFoundException {
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> tableNames = pMapper.getTableNames();
        ArrayList<ArrayList<Product>> products = new ArrayList();
        for (String tableName : tableNames) {
            products.add(pMapper.showProducts(tableName));

        }
        
    }

    @Test
    public void searchForProductTest() throws ClassNotFoundException, SQLException {
        ProductMapper pMapper = new ProductMapper();
        pMapper.searchForProduct("Iphone");
    }
    
    
    @Test
    public void getProductTest() throws ClassNotFoundException, SQLException{
        ProductMapper pMapper  = new ProductMapper();
        
        Product  product  = pMapper.getProduct(5);
        
        assertEquals("Oneplus 3", product.getName());
        assertEquals(5,  product.getID(),  0);
    }
}
