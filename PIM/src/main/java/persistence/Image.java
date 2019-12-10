package persistence;

public class Image {

    private String image; //Base 64 Encoded String  of the SQL blob to use in HTML
    private Integer productID;
    private Integer imageID;

    public Image(String image, Integer productID, Integer imageID) {
        this.image = image;
        this.productID = productID;
        this.imageID = imageID;
    }

    public String getImage() {
        return image;
    }

    public Integer getProductID() {
        return productID;
    }

    public Integer getImageID() {
        return imageID;
    }

}
