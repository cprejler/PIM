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
            if (type.contains("varchar")) {
                    //If the SQL type is VARCHAR an input box of type text is made
                  Filter filter = new  Filter(field, "hidden",fieldValues,"varchar");
                  filters.add(filter);
            }else if (type.toLowerCase().contains("tinyint")) {
                //If the SQL type is VARCHAR an input box of type number is made
                  Filter  filter = new Filter(field, "hidden", fieldValues,"tinyint");
                  filters.add(filter);
            }
            else if (type.substring(0, 2).contains("int")) {
                //If the SQL type is VARCHAR an input box of type number is made
                  Filter  filter = new Filter(field,"hidden","intfloat");
                  filters.add(filter);
            } else if (type.contains("float")) {
                  Filter filter =  new Filter(field, "hidden","intfloat");
                  filters.add(filter);
                // If it's not VARCHAR, INT  or float, we conclude it's an enum, and we create a statement, based on the Field  
            } else {
                //If the  columntype  is ENUM,  another  query is  made to get the ENUM values
                Statement stGetEnumValues = connection.createStatement();
                ResultSet rsGetEnumValues = stGetEnumValues.executeQuery("SELECT\n"
                        + "  TRIM(TRAILING ')' FROM TRIM(LEADING '(' FROM TRIM(LEADING 'enum' FROM column_type))) column_type\n"
                        + "FROM\n"
                        + "  information_schema.columns\n"
                        + "WHERE\n"
                        + "  table_schema = '"+database+"' AND table_name = '" + table + "' AND column_name = '" + field + "';");
                while (rsGetEnumValues.next()) {
                    String getEnumValues = rsGetEnumValues.getString("column_type");
                    //Regex to trim the values in  order   to create an array.
                    String trimValues = getEnumValues.replaceAll("\\\\n", "");
                    String trimValuesAgain = trimValues.replaceAll("'", "");

                    String[] enumValuesArray = trimValuesAgain.split(",");
                    List<String> enumValues = new ArrayList<String>(Arrays.asList(enumValuesArray));
                    
                    Filter filter  =  new Filter(field, "select", enumValues,"enum");
                    filters.add(filter);
                } 
            }
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

}