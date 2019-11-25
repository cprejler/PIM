package persistence;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import presentation.Form;

/**
 *
 * @author casper
 */
public class FormGenerator {

    public ArrayList<Form> generateForm(String table) throws ClassNotFoundException, SQLException {
        DataBase db = new DataBase();
        Connection connection = db.connectionValg();
        
        ArrayList<Form>  forms   = new ArrayList();
       

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT DISTINCT COLUMN_NAME, COLUMN_TYPE FROM information_schema.`COLUMNS` WHERE TABLE_NAME = '" + table + "'");
        while (rs.next()) {

            String field = rs.getString("COLUMN_NAME");

            String type = rs.getString("COLUMN_TYPE");
            if (type.contains("varchar")) {

                  Form form = new  Form(field, "text");
                  forms.add(form);

            } else if (type.contains("int")) {

                  Form  form = new Form(field,"number");
                  forms.add(form);
                // If it's not VARCHAR, INT  or float, we conclude it's an enum, and we create a statement, based on the Field   
            } else if (type.contains("float")) {
                  Form form =  new Form(field, "number");
                  forms.add(form);
                // If it's not VARCHAR, INT  or float, we conclude it's an enum, and we create a statement, based on the Field  
            } else {
                //If the  columntype  is ENUM,  another  query is  made to get the ENUM values
                Statement stGetEnumValues = connection.createStatement();
                ResultSet rsGetEnumValues = stGetEnumValues.executeQuery("SELECT\n"
                        + "  TRIM(TRAILING ')' FROM TRIM(LEADING '(' FROM TRIM(LEADING 'enum' FROM column_type))) column_type\n"
                        + "FROM\n"
                        + "  information_schema.columns\n"
                        + "WHERE\n"
                        + "  table_schema = 'test' AND table_name = '" + table + "' AND column_name = '" + field + "';");
                while (rsGetEnumValues.next()) {
                    String getEnumValues = rsGetEnumValues.getString("column_type");
                    //Regex to trim the values in  order   to create an array.
                    String trimValues = getEnumValues.replaceAll("\\\\n", "");
                    String trimValuesAgain = trimValues.replaceAll("'", "");

                    String[] enumValuesArray = trimValuesAgain.split(",");
                    List<String> enumValues = new ArrayList<String>(Arrays.asList(enumValuesArray));
                    
                    Form form  =  new Form(field, "select", enumValues);
                    forms.add(form);
                }

            }

        }
        
        //remove productID as we don't need it
        int i = 0;
        for (Form form : forms) {
            if(form.getName().equals("productID")){
                i = forms.indexOf(form);
            }
        }
        forms.remove(i);
        

        
        return forms;

    }

}
