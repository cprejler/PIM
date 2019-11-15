package businesslogic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author casper
 */
public class Product {

    private String name;
    private Integer ID;
    private String category;
    private String type;
    private String manufacturer;
    private Boolean published;
    private ArrayList<String> fields;
    private ArrayList<Object> fieldsValues;

    public Product(String name, String category, String type, String manufacturer, ArrayList<String> fields, ArrayList<Object> fieldsValues) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.manufacturer = manufacturer;
        this.fields = fields;
        this.fieldsValues = fieldsValues;
    }

    public String getName() {
        return name;
    }

    public Integer getID() {
        return ID;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Boolean getPublished() {
        return published;
    }

    public ArrayList<String> getFields() {
        return fields;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public void setFields(ArrayList<String> fields) {
        this.fields = fields;
    }

    public void setFieldsValues(ArrayList<Object> fieldsValues) {
        this.fieldsValues = fieldsValues;
    }

    public ArrayList<Object> getFieldsValues() {
        return fieldsValues;
    }
    

}
