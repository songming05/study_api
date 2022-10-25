package stripe.lsyeon.product.web;

import stripe.lsyeon.product.service.Products;

public class ProductsRetrieveResult {
        public final String productsId;

        // 생성자 Stirng 만 생성하겠다.
        public ProductsRetrieveResult(Products products) {
            this.productsId = products.prodId;
        }

}
