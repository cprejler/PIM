/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

/**
 *
 * @author casper
 */
public class Form {
    
    String name;
    String  inputType;
    String options;

    public Form(String name, String inputType, String options) {
        this.name = name;
        this.inputType = inputType;
        this.options = options;
    }

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

    public String getOptions() {
        return options;
    }
    
    
    
    
}
