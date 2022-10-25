package stripe.lsyeon.product.service;

public class Products {

    public final String prodId;
    public final String prodObject;
    public final String prodActive;
    public final String prodCreated;
    public final String prodName;

    public Products(String prodId, String prodObject, String prodActive, String prodCreated, String prodName) {
        this.prodId = prodId;
        this.prodObject = prodObject;
        this.prodActive = prodActive;
        this.prodCreated = prodCreated;
        this.prodName = prodName;
    }

}
