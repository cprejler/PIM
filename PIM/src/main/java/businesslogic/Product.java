
package businesslogic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author casper
 */
public class Product extends ProductType {
    private Integer ID;
    private String type;

    public Product(ArrayList<String> fields, String name, Integer ID, String type) {
        super.fields=fields;
        super.name=name;
        this.ID = ID;
        this.type = type;
    }

    public Integer getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
