package stripe.lsyeon.product.web;

public class ProductsProductionRequestDto {
    public final String prodName;
    public final String prodObject;
    public final String prodActive;

    public ProductsProductionRequestDto(String prodName, String prodObject, String prodActive) {
        this.prodName = prodName;
        this.prodObject = prodObject;
        this.prodActive = prodActive;
    }
}
