package stripe.lsyeon.product.service;

public class ProductsProductionRequest {
    public final String prodName;
    public final String prodObject;
    public final String prodActive;

    public ProductsProductionRequest(String prodName, String prodObject, String prodActive) {
        this.prodName = prodName;
        this.prodObject = prodObject;
        this.prodActive = prodActive;
    }
}
