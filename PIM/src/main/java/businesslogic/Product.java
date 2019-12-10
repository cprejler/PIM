package businesslogic;

import java.util.ArrayList;
import persistence.Image;

public class Product {

    private String name;
    private Integer ID;
    private String type;
    private String manufacturer;
    private Boolean published;
    private ArrayList<String> fields;
    private ArrayList<Object> fieldsValues;
    private ArrayList<Image> images;
    private String description;

    public Product(String name, String type, String manufacturer, ArrayList<String> fields, ArrayList<Object> fieldsValues) {
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.fields = fields;
        this.fieldsValues = fieldsValues;

    }

    public Product(String name, String type, String manufacturer, ArrayList<String> fields, ArrayList<Object> fieldsValues, ArrayList<Image> images) {
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.fields = fields;
        this.fieldsValues = fieldsValues;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public Integer getID() {
        return ID;
    }

    public void setType(String type) {
        this.type = type;
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

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
