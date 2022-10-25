package stripe.lsyeon.product.web;


import stripe.lsyeon.product.service.ProductsDeleteResult;

public class ProductsDeleteResultResponse {

    public final String productsId;

    public ProductsDeleteResultResponse(ProductsDeleteResult productsDeleteResult) {
        this.productsId = productsDeleteResult.productsId;
    }
}
