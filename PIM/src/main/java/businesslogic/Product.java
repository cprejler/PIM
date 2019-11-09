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
    private String name;

    public String getType() {
        return type;
    }

    public Product(ArrayList fields, String name, Integer ID, String category) {
        super.fields=fields;
        this.ID = ID;
        this.category = category;
    }

    public Integer getID() {
        return ID;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<String[]> getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
>>>>>>> 35999d31edf180fd2ded1f63ac8ac986760fbe5b
