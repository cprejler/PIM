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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jenso
 */
public class ProductMapper {
    
    DataBase db;
    Connection connection;
    public ProductMapper() throws ClassNotFoundException, SQLException{
        db = new DataBase();
        db.connection();
        connection = db.connection();
    }
    
    public void updateProduct(Product product) throws SQLException{
//        DataBase db = new DataBase();
//        db.connection();
//        Connection connection = db.connection();
//        String insertToBalance = (("UPDATE users SET balance = ? WHERE email LIKE \"%" + email + "%\""));
//        PreparedStatement statementOpdaterToBalance = connection.prepareStatement(insertToBalance);
//        statementOpdaterToBalance.setDouble(1, sum)statementOpdaterToBalance.executeUpdate();
//                } else {
//                    throw new IllegalArgumentException("Insignificant amount");
//                }
//            }
//        } catch (SQLException exc) {
//            this.exc = exc;
//        }
//        connection.close();
//    
//
//    String updateType = "UPDATE " + product.getType() + " SET "
        for (String[] fields : product.getFields()) {
            String updateProduct = (("UPDATE " +  product.getType() + " SET = ? WHERE productID = " + product.getID() ));
            PreparedStatement updateProductStatement = connection.prepareStatement(updateProduct);
            updateProductStatement.setString(1, fields[0]);
            updateProductStatement.executeUpdate();
            connection.close();
            
            
            
        }
        
    }
    
}
