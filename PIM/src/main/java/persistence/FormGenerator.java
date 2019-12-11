package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import presentation.Form;

public class FormGenerator {

    //Returns an arraylist of forms in order to dynamically created HTML forms based on product type
    public ArrayList<Form> generateForm(String table) throws ClassNotFoundException, SQLException {
        DataBase db = new DataBase();
        ChooseConnection cv = new ChooseConnection();
        Connection connection = cv.chooseConnections();
        String database = cv.getDatabase();

        ArrayList<Form> forms = new ArrayList();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT DISTINCT COLUMN_NAME, COLUMN_TYPE FROM information_schema.`COLUMNS` WHERE TABLE_NAME = '" + table + "'");
        while (rs.next()) {

            String field = rs.getString("COLUMN_NAME");

            String type = rs.getString("COLUMN_TYPE");
            if (type.contains("varchar")) {
                //If the SQL type is VARCHAR an input box of type text is made
                Form form = new Form(field, "text");
                forms.add(form);

            } else if (type.contains("int")) {
                //If the SQL type is VARCHAR an input box of type number is made
                Form form = new Form(field, "number");
                forms.add(form);

            } else if (type.contains("float")) {
                Form form = new Form(field, "number");

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
                        + "  table_schema = '" + database + "' AND table_name = '" + table + "' AND column_name = '" + field + "';");
                while (rsGetEnumValues.next()) {
                    String getEnumValues = rsGetEnumValues.getString("column_type");
                    //Regex to trim the values in  order   to create an array.
                    String trimValues = getEnumValues.replaceAll("\\\\n", "");
                    String trimValuesAgain = trimValues.replaceAll("'", "");

                    String[] enumValuesArray = trimValuesAgain.split(",");
                    List<String> enumValues = new ArrayList<String>(Arrays.asList(enumValuesArray));

                    Form form = new Form(field, "select", enumValues);
                    forms.add(form);
                }

            }

        }

        //remove productID as we don't want it when a new product is made because productID in database is auto_increment
        int i = 0;
        for (Form form : forms) {
            if (form.getName().equals("productID")) {
                i = forms.indexOf(form);
            }
        }
        forms.remove(i);

        return forms;

    }

}
