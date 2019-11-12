
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

    public void updateProduct(Product product) throws SQLException {
        DataBase db = new DataBase();

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
        for (Object product2 : product.getFields()) {
            updateProductStatement.setObject(columnIndex, product2);
            columnIndex++;
        }
        updateProductStatement.setInt(columnIndex, product.getID());
        updateProductStatement.executeUpdate();
        connection.close();

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
        for (Object field : product.getFields()) {
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
        for (Object field : product.getFields()) {
            statementInsertProductType.setObject(columnIndex, field);
            columnIndex++;
        }
        statementInsertProductType.setObject(product.getFields().size() + 1, product.getID());

        statementInsertProductType.executeUpdate();
        connection.close();
    }

    public void deleteProduct(Product product) throws ClassNotFoundException, SQLException {
        Connection connection = db.connection();


        String updateTrue = "DELETE FROM product WHERE product.productID=?";
        PreparedStatement ps = connection.prepareStatement(updateTrue);
        ps.setInt(1, product.getID());
        ps.executeUpdate();
    }



}
