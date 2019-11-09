
package persistence;

import businesslogic.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author casper
 */
public class ProductMapper {
    DataBase db = new DataBase();
    public void insertProduct(Product product) throws SQLException, ClassNotFoundException{
        Connection connection = db.connection();
        
        
        String insertProduct = "INSERT  INTO PIM. " +product.getType() +  "() VALUES(?)";
        PreparedStatement statementInsertProduct = connection.prepareStatement(insertProduct);
        statementInsertProduct.setString();
        statementInsertProduct.executeUpdate();
        
    }
    
}
