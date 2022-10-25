package stripe.lsyeon.product.web;

import org.springframework.web.bind.annotation.*;
import stripe.lsyeon.product.common.ProductsId;
import stripe.lsyeon.product.service.*;


@RestController
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("api/v1/products/{id}")
    public ProductsRetrieveResult retrieveProducts(@PathVariable String id) {
        Products products = productsService.retrieveProducts(id);
        return new ProductsRetrieveResult(products);
    }

    @PostMapping("api/v1/products")
    public ProductsRetrieveResult createProducts(@RequestBody ProductsProductionRequestDto productsProductionRequestDto) {

        //Products products = productsService.createProducts(new ProductsProductionRequest(ProductsProductionRequestDto.prodName, productsProductionRequestDto.prodObject, productsProductionRequestDto.prodActive));
        Products products = productsService.createProducts(new ProductsProductionRequest(productsProductionRequestDto.prodName, productsProductionRequestDto.prodObject, productsProductionRequestDto.prodActive));

        /* ProductsCreateResult */
        return new ProductsRetrieveResult(products);
    }

    @DeleteMapping("api/v1/products/{id}")
    public ProductsDeleteResultResponse deleteProducts(@PathVariable String id) {

        ProductsId productsId = new ProductsId(id);

        ProductsDeleteResult productsDeleteResult = productsService.delete(productsId);

        return new ProductsDeleteResultResponse(productsDeleteResult);
    }

}

