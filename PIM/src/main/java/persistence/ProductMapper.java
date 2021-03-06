package persistence;

import businesslogic.Product;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

public class ProductMapper {

    DataBase db;
    ChooseConnection cv;
    Connection connection = null;

    /**
     * 
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
     * @throws SQLException An exception that provides information on a database access error or other errors.
 
     */
    public ProductMapper() throws ClassNotFoundException, SQLException {
        cv = new ChooseConnection();
        connection = cv.chooseConnections();

    }

    /**
     * 
     * @param productList takes an ArrayList of products, to update the database.
     * @throws SQLException An exception that provides information on a database access error or other errors.
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
     */
    public void updateProduct(ArrayList<Product> productList) throws SQLException, ClassNotFoundException {
        connection = cv.chooseConnections();

        for (Product product : productList) {

            String updateProduct = "UPDATE product SET productName = ?, productType = ?, manufacturer = ?, description = ? WHERE productID = " + product.getID();
            PreparedStatement statementUpdateProduct = connection.prepareStatement(updateProduct);
            statementUpdateProduct.setString(1, product.getName());
            statementUpdateProduct.setString(2, product.getType());
            statementUpdateProduct.setString(3, product.getManufacturer());
            statementUpdateProduct.setString(4, product.getDescription());
            statementUpdateProduct.execute();

            ArrayList<String> columnNames = new ArrayList<String>();

            Statement getColumnNames = connection.createStatement();
            ResultSet rs = getColumnNames.executeQuery("SELECT * from " + product.getType());
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

    /**
     * 
     * @param product recieves a product object to insert in the database.
     * @throws SQLException An exception that provides information on a database access error or other errors.
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
     */
    public void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        connection = cv.chooseConnections();

        //Insert a product and get the ID to create a product type after
        Integer productID = 0;
        String insertProduct = "INSERT INTO  product (productName, productType, manufacturer, description) VALUES(?,?,?,?)";
        PreparedStatement statementInsertProduct = connection.prepareStatement(insertProduct);
        statementInsertProduct.setString(1, product.getName());
        statementInsertProduct.setString(2, product.getType().toLowerCase());
        statementInsertProduct.setString(3, product.getManufacturer());
        statementInsertProduct.setString(4, product.getDescription());
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
        ResultSet rs = getColumnNames.executeQuery("SELECT * from " + product.getType().toLowerCase());
        //Get names of the columns to be inserted into
        ResultSetMetaData rsmd = rs.getMetaData();
        int intColumnCount = rsmd.getColumnCount();
        for (int i = 0; i < intColumnCount; i++) {
            columnNames.add(rsmd.getColumnName(i + 1));
        }
        //Create fields and insert values to use in PreparedStatement
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
        String insertProductType = "INSERT  INTO " + product.getType().toLowerCase() + "(" + statementFields + ")" + " VALUES(" + statementValues + ")";
        PreparedStatement statementInsertProductType = connection.prepareStatement(insertProductType);
        for (Object field : product.getFieldsValues()) {
            statementInsertProductType.setObject(columnIndex, field);
            columnIndex++;
        }
        statementInsertProductType.setObject(product.getFieldsValues().size() + 1, product.getID());

        statementInsertProductType.executeUpdate();
        connection.close();
    }
/**
 * 
 * @param product recieves a product object to delete. 
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public void deleteProduct(Product product) throws ClassNotFoundException, SQLException {
        connection = cv.chooseConnections();
        String deleteProductType = "DELETE FROM " + product.getType() + " where " + product.getType() + ".productID=?";
        PreparedStatement deleteProductTypeSt = connection.prepareStatement(deleteProductType);
        deleteProductTypeSt.setInt(1, product.getID());
        deleteProductTypeSt.executeUpdate();

        String deleteProduct = "DELETE FROM product WHERE product.productID=?";
        PreparedStatement deleteProductSt = connection.prepareStatement(deleteProduct);
        deleteProductSt.setInt(1, product.getID());
        deleteProductSt.executeUpdate();
    }


    /**

     * @param productType takes argument of a productType.
     * @return Method returns an arraylist of product,
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public ArrayList<Product> showProducts(String productType) throws ClassNotFoundException, SQLException {
        connection = cv.chooseConnections();
        ProductMapper pm = new ProductMapper();
        ArrayList<Product> products = new ArrayList<Product>();
        String name = "";
        String manufacturer = "";
        String description = "";

        String showProductQuery = "SELECT product.manufacturer,  product.productName, product.description, product.productType, " + productType + ".* FROM product"
                + ", " + productType + " where product.productID=" + productType + ".productID order by productID";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(showProductQuery);
        ResultSetMetaData rsmd = rs.getMetaData();

        int intColumnCount = rsmd.getColumnCount();
        //Get columncount to iterate over.
        while (rs.next()) {
            //fieldValues are row values in the database and fields are the column headers.
            ArrayList<Object> fieldValues = new ArrayList<>();
            ArrayList<String> fields = new ArrayList<>();
            for (int j = 0; j < intColumnCount; j++) {
                fields.add(rsmd.getColumnName(j + 1));
                fieldValues.add(rs.getObject(j + 1));
                name = rs.getString("productName");
                manufacturer = rs.getString("manufacturer");
                description = rs.getString("description");

            }
            ArrayList<Image> images = pm.getImages(connection, rs.getInt("ProductID"));
            Product product = new Product(name, manufacturer, productType, fields, fieldValues, images);
            product.setID(rs.getInt("productID"));
            product.setDescription(description);
            products.add(product);

        }
        connection.close();

        return products;
    }

    /**
     * Used to forward  the right items from ShowProducts.jsp to UpdateProduct.jsp as well as SpecificProduct.jsp.
     * @param id recieves the productID to get. 
     * @return Return a product from a productID.
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public Product getProduct(Integer id) throws ClassNotFoundException, SQLException {
        connection = cv.chooseConnections();
        String productType = "";
        String productName = "";
        String manufacturer = "";
        String description = "";
        String getProductType = "SELECT  * FROM  product where productID = " + id + "";
        Statement statement = connection.createStatement();
        ResultSet rsGetType = statement.executeQuery(getProductType);
        while (rsGetType.next()) {
            productType = rsGetType.getString("productType");
            productName = rsGetType.getString("productName");
            manufacturer = rsGetType.getString("manufacturer");
            description = rsGetType.getString("description");

        }

        ArrayList<String> fields = new ArrayList<>();
        ArrayList<Object> fieldValues = new ArrayList();

        String getFieldsAndValues = "SELECT *  FROM " + productType + " where productID=" + id + "";

        ResultSet rsGetFieldsAndValues = statement.executeQuery(getFieldsAndValues);
        ResultSetMetaData rsmd = rsGetFieldsAndValues.getMetaData();
        int columnCount = rsmd.getColumnCount();
        while (rsGetFieldsAndValues.next()) {
            for (int i = 0; i < columnCount; i++) {
                fields.add(rsmd.getColumnName(i + 1));
                fieldValues.add(rsGetFieldsAndValues.getObject(i + 1));
            }

        }
        ArrayList<Image> images = getImages(connection, id);
        Product product = new Product(productName, productType, manufacturer, fields, fieldValues, images);
        product.setID(id);
        product.setDescription(description);
        connection.close();
        return product;

    }
    /**
     * 
     * @param newproduct recieves the name of the new product.
     * @return returns a string of enumvalues for processing.
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public String alterProductTypeEnum(String newproduct) throws SQLException {
        newproduct = ",'" + newproduct + "'";
        String product = "product";  //Tabel navn

        String productType = "productType"; //Kolonne navn i tabel

        String getEnumsQuery = getProductEnums(product, productType);

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery(getEnumsQuery);
        String enums = "";

        while (rs.next()) {
            enums = rs.getString("COLUMN_TYPE");

        }

        String newEnumVars = enums;
        if (!enums.contains(newproduct)) {

            StringBuilder sb = new StringBuilder(enums);
            sb.insert(sb.length() - 1, newproduct);
            enums = sb.toString();
            newEnumVars = enums;
            newEnumVars = newEnumVars.toLowerCase();
            String alterTableQuery = "alter table product modify column productType " + newEnumVars;
            st.executeUpdate(alterTableQuery);

        }

        return newEnumVars;
    }

    /**
     * 
     * @param TableName recieves the tablename of the new product.
     * @param ColumnName recieves the columnname the for the product.
     * @return returns an SQL query.
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public String getProductEnums(String TableName, String ColumnName) throws SQLException {
        TableName = "'" + TableName + "'";
        ColumnName = "'" + ColumnName + "'";
        String database = "'" + cv.getDatabase() + "'";

        String getEnumsQuery = "SELECT COLUMN_TYPE FROM information_schema.`COLUMNS` WHERE TABLE_SCHEMA = " + database + " AND TABLE_NAME = " + TableName + " AND COLUMN_NAME =" + ColumnName + "";
        return getEnumsQuery;
    }
/**
 * 
 * @param product recieves an arraylist of the new product. 
 * @param enums revieves enum values for the new product.
 * @return returns a string of the query used to generate the table
 * @throws SQLException An exception that provides information on a database access error or other errors.
 */
    public String createProductTable(ArrayList product, ArrayList enums) throws SQLException {
        Statement st = connection.createStatement();
        String CreateTableQuery = "";
        StringBuilder sb = new StringBuilder();
        String foreignKeyProductID = "productID int(5) unsigned zerofill NOT NULL, \n"
                + " foreign key (productID) references product(productID))";
        int p = 0;
        for (int i = 0; i < product.size(); i++) {
            if (i == 0) {
                String productType = product.get(i).toString().toLowerCase();
                CreateTableQuery = "CREATE TABLE " + productType + " (";
                alterProductTypeEnum(productType);

            }
            String products = (String) product.get(i);
            sb = new StringBuilder(products);

            switch (sb.charAt(0)) {
                case 'S':
                    String varChar = sb.substring(1) + " varchar(200), \n";
                    CreateTableQuery = CreateTableQuery + varChar;
                    break;
                case 'I':
                    String varInt = sb.substring(1) + " int, \n";
                    CreateTableQuery = CreateTableQuery + varInt;
                    break;
                case 'F':
                    String varfloat = sb.substring(1) + " float, \n";
                    CreateTableQuery = CreateTableQuery + varfloat;
                    break;

                case 'E':
                    String varEnum = sb.substring(1) + " enum(" + convertToSQLEnum(enums.get(p).toString()) + "), \n";
                    CreateTableQuery = CreateTableQuery + varEnum;
                    p++;
                default:
                    break;
            }
        }

        CreateTableQuery = CreateTableQuery + foreignKeyProductID;
        st.executeUpdate(CreateTableQuery);

        connection.close();

        return CreateTableQuery;

    }
/**
 * 
 * @return returns an ArrayList of tablenames in the database.
 * @throws SQLException An exception that provides information on a database access error or other errors.
 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
 */
    public ArrayList<String> getTableNames() throws SQLException, ClassNotFoundException {
        connection = cv.chooseConnections();
        //Method used to get table names in database and later used for calling showProducts on each table returned
        String database = cv.getDatabase();
        ArrayList<String> tableNames = new ArrayList();
        Statement st = connection.createStatement();
        String getTableNames = "SELECT TABLE_NAME \n"
                + "FROM INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA='" + database + "';";
        ResultSet rs = st.executeQuery(getTableNames);

        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if (tableName.toString().equals("product") || (tableName.toString().contains("test")) || tableName.toString().equals("images")) {
            } else {
                tableNames.add(tableName);
            }
        }
        connection.close();
        return tableNames;

    }
/**
 * 
 * @param input recieves a string of the desired search rssult. 
 * @return return a Arraylist of the given product/products.
 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
 * @throws SQLException An exception that provides information on a database access error or other errors.
 */
    public ArrayList<Product> searchForProduct(String input) throws ClassNotFoundException, SQLException {
        connection = cv.chooseConnections();
        ArrayList<Product> products = new ArrayList<Product>();
        String name = "";
        String manufacturer = "";

        ArrayList<String> productID = new ArrayList<String>();
        ArrayList<String> productType = new ArrayList<String>();

        String searchQuery = "SELECT product.productID, product.productType FROM product where productName like "
                + "'%" + input + "%' or productID like " + "'%" + input + "%' ORDER BY productType";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(searchQuery);

        while (rs.next()) {
            productID.add(rs.getString("productID"));

            productType.add(rs.getString("productType"));
        }

        for (int i = 0; i < productID.size(); i++) {
            String showSearchQuery = "SELECT product.manufacturer,  product.productName, product.productType, product.description, " + productType.get(i) + ".* FROM product"
                    + ", " + productType.get(i) + " where product.productID=" + productID.get(i) + " and " + productType.get(i) + ".productID =" + productID.get(i);

            ResultSet rs1 = statement.executeQuery(showSearchQuery);
            ResultSetMetaData rsmd = rs1.getMetaData();

            int intColumnCount = rsmd.getColumnCount();
            ProductMapper pm = new ProductMapper();

            while (rs1.next()) {
                ArrayList<Object> fieldValues = new ArrayList<>();
                ArrayList<String> fields = new ArrayList<>();
                for (int j = 0; j < intColumnCount; j++) {
                    fields.add(rsmd.getColumnName(j + 1));
                    fieldValues.add(rs1.getObject(j + 1));
                    name = rs1.getString("productName");
                    manufacturer = rs1.getString("manufacturer");

                }
                ArrayList<Image> images = pm.getImages(connection, rs1.getInt("ProductID"));
                Product product = new Product(name, manufacturer, productType.get(i), fields, fieldValues, images);
                product.setID(rs1.getInt("ProductID"));
                product.setType(rs1.getString("productType"));
                product.setDescription(rs1.getString("description"));
                products.add(product);
            }
        }
        connection.close();
        return products;
    }
/**
 * 
 * @param Enums recieves a string of values.
 * @return returns the same values in enum format.
 */
    public String convertToSQLEnum(String Enums) {
        String EnumsToSQL = "'";
        String[] parts = Enums.split(",");
        ArrayList parts2 = new ArrayList();

        for (int i = 0; i < parts.length; i++) {
            parts2.add(parts[i]);
        }

        for (int i = 0; i < parts2.size(); i++) {
            EnumsToSQL = EnumsToSQL + parts2.get(i) + "','";
        }

        StringBuilder sb = new StringBuilder(EnumsToSQL);
        EnumsToSQL = EnumsToSQL.substring(0, EnumsToSQL.length() - 2);

        return EnumsToSQL;

    }
/**
 * 
 * @param connection recieves connection.
 * @param productID recieves the productID of an item.
 * @return returns an Arraylist of images.
 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
 * @throws SQLException An exception that provides information on a database access error or other errors.
 */
    public ArrayList<Image> getImages(Connection connection, Integer productID) throws ClassNotFoundException, SQLException {
        ArrayList<Image> images = new ArrayList<>();

        String SQL = "SELECT * from images where productID =" + productID + "";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SQL);
        while (rs.next()) {
            Integer imageID = rs.getInt("imageID");
            Blob blob = rs.getBlob("image");
            //Get byte array
            byte[] imageAsByte = blob.getBytes(1, (int) blob.length());

            // Encode to base64 to be able to display it in  html
            String base64Encoded = Base64.getEncoder().encodeToString(imageAsByte);
            Image image = new Image(base64Encoded, productID, imageID);
            images.add(image);

        }

        return images;

    }
/**
 * 
 * @param productType recieves a string of the productType.
 * @param field recieves a string of a column in the given producttype.
 * @param fieldValue recieves a string of the value to filter for.
 * @return returns an ArrayList of the filtered products.
 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using
 * @throws SQLException An exception that provides information on a database access error or other errors. 
 */
    public ArrayList<Product> filteredProducts(String productType, String field, String fieldValue) throws ClassNotFoundException, SQLException {
        Connection connection = cv.chooseConnections();

        ArrayList<Product> products = new ArrayList<>();

        //Generate query based on productType and a field
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * from ");
        sb.append(productType);
        sb.append(" where ");
        sb.append(field);
        sb.append(" like ");
        sb.append(fieldValue);
        String query = "";

        if (field.equals("manufacturer")) {
            query = "SELECT * FROM product where manufacturer like '" + fieldValue + "'";
        } else if (field.equals("productName")) {
            query = "SELECT * FROM product where productName like '" + fieldValue + "'";
        } else {
            query = "SELECT * FROM " + productType + " where " + field + " like '" + fieldValue + "'";
        }
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Integer productID = rs.getInt("productID");
            Product product = getProduct(productID);
            products.add(product);
        }

        return products;

    }

}
