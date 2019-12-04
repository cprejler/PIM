/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casper
 */
public class Form {
    
    String name;
    String  inputType;
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
