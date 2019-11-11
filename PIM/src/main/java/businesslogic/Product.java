package businesslogic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author casper
 */
public class Product extends ProductEntity {
    private Integer ID;
    private String category;
    private String type;
    private String manufacturer;
    private Boolean published;

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    

    public Product(ArrayList fields, String name, String category, String type, String manufacturer) {
        super.fields=fields;
        super.name=name;
        this.category = category;
        this.type = type;
        this.manufacturer=manufacturer;
    }

    public Integer getID() {
        return ID;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<Object> getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public String getManufacturer(){
        return manufacturer;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    
}

