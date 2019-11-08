
package businesslogic;

import java.util.HashMap;

/**
 *
 * @author casper
 */
public class Product extends ProductEntity {
    private Integer ID;
    private String category;

    public Product(HashMap<String, Object> fields, String name, Integer ID, String category) {
        super.fields=fields;
        super.name=name;
        this.ID = ID;
        this.category = category;
    }

    public Integer getID() {
        return ID;
    }

    public String getCategory() {
        return category;
    }

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
