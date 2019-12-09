/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import presentation.Filter;

/**
 *
 * @author jonat
 */
public class FilterGenerator {
    public ArrayList<Filter> generateFilter(String table) throws ClassNotFoundException, SQLException {
        DataBase db = new DataBase();
        ChooseConnection cv = new ChooseConnection();
        Connection connection = cv.chooseConnections();
        String database = cv.getDatabase();
        ArrayList<Filter>  filters  = new ArrayList();
        
        manufacturer(connection, table, filters);
        productName(connection, table, filters);
        

        Statement st = connection.createStatement();
        Statement st2 = connection.createStatement(); 
        ResultSet rs = st.executeQuery("SELECT DISTINCT COLUMN_NAME, COLUMN_TYPE FROM information_schema.`COLUMNS` WHERE TABLE_NAME = '" + table + "'");
        while (rs.next()) {
            String field = rs.getString("COLUMN_NAME");
            String type = rs.getString("COLUMN_TYPE");
            ResultSet rsValues = st2.executeQuery("SELECT DISTINCT "+field+" FROM "+table+";");
            ArrayList<String> fieldValues = new ArrayList();
            
            while (rsValues.next()){
            String fieldValue = rsValues.getString(field);
            fieldValues.add(fieldValue);
                    }
            
                             Filter filter = new  Filter(field, "hidden",fieldValues,"varchar");
                  filters.add(filter);
         
            }
        
        //remove productID as we don't want it when a new product is made because productID in database is auto_increment
        int i = 0;
        for (Filter filter : filters) {
            if(filter.getName().equals("productID")){
                i = filters.indexOf(filter);
            }
        } 
        filters.remove(i);
        
 

        
        return filters;

    }

    public void manufacturer(Connection connection, String table, ArrayList<Filter> filters) throws SQLException {
        String field  = "manufacturer";
        Statement st3 = connection.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT distinct manufacturer from product where productType = '"+table+"'");
        ArrayList<String> manufacvalues = new ArrayList();
        while (rs3.next()) {

            String fieldValue = rs3.getString(field);
            manufacvalues.add(fieldValue);
        }
        Filter filter2 = new  Filter(field, "hidden",manufacvalues,"manufacAndProductName");
        filters.add(filter2);
    }
    
        public void productName(Connection connection, String table, ArrayList<Filter> filters) throws SQLException {
        String field  = "productName";
        Statement st3 = connection.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT distinct productName from product where productType = '"+table+"'");
        ArrayList<String> manufacvalues = new ArrayList();
        while (rs3.next()) {

            String fieldValue = rs3.getString(field);
            manufacvalues.add(fieldValue);
        }
        Filter filter2 = new  Filter(field, "hidden",manufacvalues,"manufacAndProductName");
        filters.add(filter2);
    }
    
 
    
    

}
