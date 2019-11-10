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

    

    public Product(ArrayList fields, String name, Integer ID, String category, String type, String manufacturer) {
        super.fields=fields;
        super.name=name;
        this.ID = ID;
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
    
}

