package stripe.lsyeon.product.web;

import org.springframework.web.bind.annotation.*;
import stripe.lsyeon.product.service.Products;
import stripe.lsyeon.product.service.ProductsProductionRequest;
import stripe.lsyeon.product.service.ProductsService;


@RestController
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("api/v1/products/{id}")
    public ProductsRetrieveResult retrieveProducts(@PathVariable String id) {
        Products products = productsService.retrieveProducts(id);// 찾아왔는데 받은 그릇이 없어요.
        return new ProductsRetrieveResult(products);
    }

    @PostMapping("api/v1/products")
    public ProductsRetrieveResult createProducts(@RequestBody ProductsProductionRequestDto productsProductionRequestDto) {

        //Products products = productsService.createProducts(new ProductsProductionRequest(ProductsProductionRequestDto.prodName, productsProductionRequestDto.prodObject, productsProductionRequestDto.prodActive));
        Products products = productsService.createProducts(new ProductsProductionRequest(productsProductionRequestDto.prodName, productsProductionRequestDto.prodObject, productsProductionRequestDto.prodActive));

        /* ProductsCreateResult */
        return new ProductsRetrieveResult(products);
    }

}

