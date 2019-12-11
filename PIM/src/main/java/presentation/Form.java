package presentation;

import java.util.List;

public class Form {

    String name;
    String inputType;
    List<String> options;

    //Constructor if it's an ENUM
    public Form(String name, String inputType, List<String> options) {
        this.name = name;
        this.inputType = inputType;
        this.options = options;
    }

    //Regular constructor
    public Form(String name, String inputType) {
        this.name = name;
        this.inputType = inputType;
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
