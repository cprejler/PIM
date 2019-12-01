/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Blob;

/**
 *
 * @author casper
 */
public class Image {
    
    private Blob image;
    private Integer productID;
    private Integer imageID;

    public Image(Blob image, Integer productID, Integer imageID) {
        this.image = image;
        this.productID = productID;
        this.imageID = imageID;
    }

    public Blob getImage() {
        return image;
    }

    public Integer getProductID() {
        return productID;
    }

    public Integer getImageID() {
        return imageID;
    }
    
    
    
    
}
