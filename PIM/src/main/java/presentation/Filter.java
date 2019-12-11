package presentation;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    String name;
    String inputType;
    String iD;
    ArrayList<String> value;
    List<String> options;

    //Constructor if it's an ENUM
    public Filter(String name, String inputType, List<String> options, String iD) {
        this.name = name;
        this.inputType = inputType;
        this.options = options;
        this.iD = iD;
    }

    //Regular constructor
    public Filter(String name, String inputType, String iD) {
        this.name = name;
        this.inputType = inputType;
        this.iD = iD;
    }

    //Filter constructor
    public Filter(String name, String inputType, ArrayList<String> value, String iD) {
        this.name = name;
        this.inputType = inputType;
        this.value = value;
        this.iD = iD;
    }

    public String getiD() {
        return iD;
    }

    public ArrayList<String> getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getInputType() {
        return inputType;
    }

    public List<String> getOptions() {
        return options;
    }

}
