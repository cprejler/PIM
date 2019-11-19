
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import businesslogic.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jenso
 */
public class ProductMapper {

    DataBase db;
    Connection connection;

    public ProductMapper() throws ClassNotFoundException, SQLException {
        db = new DataBase();
        db.connection();
        connection = db.connection();
    }

    public void updateProduct(ArrayList<Product> productList) throws SQLException {
        DataBase db = new DataBase();

        for (Product product : productList) {

            String updateProduct = "UPDATE product SET productName = ?, productType = ?, manufacturer = ?, published = ? WHERE productID = " + product.getID();
            PreparedStatement statementUpdateProduct = connection.prepareStatement(updateProduct);
            statementUpdateProduct.setString(1, product.getName());
            statementUpdateProduct.setString(2, product.getType());
            statementUpdateProduct.setString(3, product.getManufacturer());
            statementUpdateProduct.setBoolean(4, product.getPublished());
            statementUpdateProduct.execute();

            ArrayList<String> columnNames = new ArrayList<String>();

            Statement getColumnNames = connection.createStatement();
            ResultSet rs = getColumnNames.executeQuery("SELECT * from PIM." + product.getType());
            //Get names of the columns to be inserted into
            ResultSetMetaData rsmd = rs.getMetaData();
            int intColumnCount = rsmd.getColumnCount();
            for (int i = 0; i < intColumnCount; i++) {
                columnNames.add(rsmd.getColumnName(i + 1));
            }
            //Create fields and insert values to insert
            StringBuilder statementFields = new StringBuilder();
            StringBuilder statementValues = new StringBuilder();

            for (String column : columnNames) {
                statementFields.append(column);

                statementFields.append(" = ?, ");
            }
            // Delete last "," at the end to avoid SQL syntax error
            statementFields.deleteCharAt(statementFields.length() - 1);
            statementFields.deleteCharAt(statementFields.length() - 1);

            String updateProductType = (("UPDATE " + product.getType() + " SET " + statementFields + " WHERE productID =  ?"));

            PreparedStatement updateProductStatement = connection.prepareStatement(updateProductType);
            int columnIndex = 1;
            String as = (String) product.getFieldsValues().get(1);
            for (Object product2 : product.getFieldsValues()) {
                updateProductStatement.setObject(columnIndex, product2);
                columnIndex++;
            }
            updateProductStatement.setInt(columnIndex, product.getID());
            updateProductStatement.executeUpdate();
            connection.close();
        }

    }

    public void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = db.connection();

        //Insert a product and get the ID to create a product type after
        Integer productID = 0;
        String insertProduct = "INSERT INTO  product (productName, productType, manufacturer) VALUES(?,?,?)";
        PreparedStatement statementInsertProduct = connection.prepareStatement(insertProduct);
        statementInsertProduct.setString(1, product.getName());
        statementInsertProduct.setString(2, product.getType());
        statementInsertProduct.setString(3, product.getManufacturer());
        statementInsertProduct.execute();

        Statement getProductID = connection.createStatement();
        ResultSet rsGetProductID = getProductID.executeQuery("SELECT * FROM product");
        while (rsGetProductID.next()) {
            rsGetProductID.last();
            productID = rsGetProductID.getInt("productID");
        }
        product.setID(productID);
        // We now have the productID to insert productType

        ArrayList<String> columnNames = new ArrayList<String>();
        //Get the names of columns to be  inserted into
        Statement getColumnNames = connection.createStatement();
        ResultSet rs = getColumnNames.executeQuery("SELECT * from PIM." + product.getType());
        //Get names of the columns to be inserted into
        ResultSetMetaData rsmd = rs.getMetaData();
        int intColumnCount = rsmd.getColumnCount();
        for (int i = 0; i < intColumnCount; i++) {
            columnNames.add(rsmd.getColumnName(i + 1));
        }
        //Create fields and insert values to insert
        StringBuilder statementFields = new StringBuilder();
        StringBuilder statementValues = new StringBuilder();
        for (Object field : product.getFieldsValues()) {
            statementValues.append("?,");

        }
        statementValues.append("?");
        for (String column : columnNames) {
            statementFields.append(column);
            statementFields.append(", ");
        }
        // Delete last "," at the end to avoid SQL syntax error
        statementFields.deleteCharAt(statementFields.length() - 1);
        statementFields.deleteCharAt(statementFields.length() - 1);

        Integer columnIndex = 1;
        String insertProductType = "INSERT  INTO " + product.getType() + "(" + statementFields + ")" + " VALUES(" + statementValues + ")";
        PreparedStatement statementInsertProductType = connection.prepareStatement(insertProductType);
        for (Object field : product.getFieldsValues()) {
            statementInsertProductType.setObject(columnIndex, field);
            columnIndex++;
        }
        statementInsertProductType.setObject(product.getFieldsValues().size() + 1, product.getID());

        statementInsertProductType.executeUpdate();
        connection.close();
    }

    public void deleteProduct(Product product) throws ClassNotFoundException, SQLException {
        Connection connection = db.connection();

        String delete = "DELETE FROM product WHERE product.productID=?";
        PreparedStatement ps = connection.prepareStatement(delete);
        ps.setInt(1, product.getID());
        ps.executeUpdate();
    }

    public ArrayList<Product> showProducts(String productType) throws ClassNotFoundException, SQLException {
        Connection connection = db.connection();
        ArrayList<Product> products = new ArrayList<Product>();
        String name = "";
        String manufacturer = "";
        String category = "";

        String showProductQuery = "SELECT product.manufacturer,  product.productName, product.productType, " + productType + ".* FROM product"
                + ", " + productType + " where product.productID=" + productType + ".productID order by productID";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(showProductQuery);
        ResultSetMetaData rsmd = rs.getMetaData();

        int intColumnCount = rsmd.getColumnCount();

        while (rs.next()) {

            ArrayList<Object> fieldValues = new ArrayList<>();
            ArrayList<String> fields = new ArrayList<>();
            for (int j = 0; j < intColumnCount; j++) {
                fields.add(rsmd.getColumnName(j + 1));
                fieldValues.add(rs.getObject(j + 1));
                name = rs.getString("productName");
                manufacturer = rs.getString("manufacturer");

            }
            Product product = new Product(name, manufacturer, category, productType, fields, fieldValues);
            products.add(product);

        }

        return products;
    }

    public ArrayList<String> getMetaData() throws SQLException {

        Statement getMetaData = connection.createStatement();
        ResultSet rs = getMetaData.executeQuery("SELECT * from product");
        ResultSetMetaData rsmd = rs.getMetaData();

        return null;
        
        
    }
    

    public String alterProductTypeEnum(String product) throws SQLException {
        product = ",'"+product+"'"; 
        String getEnumsQuery = "SELECT COLUMN_TYPE FROM information_schema.`COLUMNS` WHERE TABLE_NAME = 'product' AND COLUMN_NAME = 'productType'";
        Statement st = connection.createStatement();  
        ResultSet rs = st.executeQuery(getEnumsQuery);
        String enums = ""; 
        
        while (rs.next()) {
            enums = rs.getString("COLUMN_TYPE"); 
                 
        }

        StringBuilder sb = new StringBuilder(enums);
        sb.insert(sb.length()-1, product);
        enums = sb.toString(); 
        String newEnumVars = enums; 
        
//        ArrayList<String> derp = new ArrayList();
//      String split[] = newEnumVars.split("'"+"*"+"'" , 0); 
//        for (int i = 0; i < split.length; i++) {
//                derp.add(split[i]);
//            }
//        for (int i = 0; i < derp.size(); i++) {
//                if(derp.get(i).contains(",")) {
//                    derp.remove(i);
//                }
//            
//        }
                
        
        String alterTableQuery = "alter table product modify column productType " + newEnumVars ;
        st.executeUpdate(alterTableQuery);
        connection.close();
        
        return newEnumVars;
    }
    
    public String createProductTable (ArrayList product, ArrayList enums) throws SQLException { 
        Statement st = connection.createStatement(); 
        String CreateTableQuery = "";
        StringBuilder sb = new StringBuilder();
        String foreignKeyProductID = " foreign key (productID) references product(productID))"; 
        
        for (int i = 0; i < product.size(); i++) {
            int l = 0; 
            if (i == 0) {
                CreateTableQuery = "CREATE TABLE " + product.get(i) +"( "
                        + "productID int(5) unsigned zerofill NOT NULL, " ; 
            }
            String products = (String) product.get(i); 
            sb = new StringBuilder (products);
            
            switch (sb.charAt(0)) {
                case 'S':
                    String varChar = sb.substring(1) + " varchar(200), \n";
                    CreateTableQuery = CreateTableQuery +varChar;
                    break;
                case 'I':
                    String varInt = sb.substring(1)+ " int, \n";
                    CreateTableQuery = CreateTableQuery +varInt;
                    break;
                case 'F':
                    String varfloat = sb.substring(1)+ " float, \n"; 
                    CreateTableQuery = CreateTableQuery +varfloat;
                    break;
                case 'E': 
                    String varEnum = sb.substring(1) + " enum("+ enums.get(l).toString()+"), \n" ;
                    CreateTableQuery = CreateTableQuery +varEnum;
                    l++;
                default:
                    break;
            }
        }
        CreateTableQuery = CreateTableQuery + foreignKeyProductID ;
        
        st.executeUpdate(CreateTableQuery); 
        connection.close();
        
        return CreateTableQuery;
        
    }
    
   
}
