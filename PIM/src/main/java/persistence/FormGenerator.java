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

/**
 *
 * @author casper
 */
public class FormGenerator {

    public ArrayList<HashMap<String, Object>> generateForm(String table) throws ClassNotFoundException, SQLException {
        DataBase db = new DataBase();
        Connection connection = db.connectionValg();
        ArrayList<HashMap<String, Object>> forms = new ArrayList<>();
        
        /*
        The form HashMap:
        "name" = the name  attribute of the input box,  to idenfity it later
        "inputType" = the  type of input box  to generate
        "options" = if the input box key is "select" the options can  be accessed with this key, comes  as ArrayList<String>
              
        */

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT DISTINCT COLUMN_NAME, COLUMN_TYPE FROM information_schema.`COLUMNS` WHERE TABLE_NAME = '" + table + "'");
        while (rs.next()) {

            String field = rs.getString("COLUMN_NAME");

            String type = rs.getString("COLUMN_TYPE");
            if (type.contains("varchar")) {
                HashMap<String, Object> form = new HashMap<>();
                form.put("name", field);
                form.put("inputType", "text");
                forms.add(form);

            } else if (type.contains("int")) {
                HashMap<String, Object> form = new HashMap<>();
                form.put("name", field);
                form.put("inputType", "number");
                forms.add(form);
                // If it's not VARCHAR or INT, we conclude it's an enum, and we create a statement, based on the Field   
            } else if (type.contains("float")) {
                HashMap<String, Object> form = new HashMap<>();
                form.put("name", field);
                form.put("inputType", "number");
                forms.add(form);

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
                    //enumValues = Arrays.asList(enumValuesArray);
                    HashMap<String, Object> form = new HashMap<>();
                    form.put("name", field);
                    form.put("inputType",  "select");
                    form.put("options",  enumValues);
                    forms.add(form);
                }

            }

        }
        
        //remove productID as we don't need it
        int i = 0;
        for (HashMap<String, Object> form : forms) {
            if(form.get("name").equals("productID")){
                i = forms.indexOf(form);
            }
        }
        forms.remove(i);
            
        
        return forms;

    }

}
