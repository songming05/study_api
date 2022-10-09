package stripe.yeon.products.web;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {

    @GetMapping("api/v1/products/{id}")
    public String retrieveProducts(@PathVariable String id) {
        return id + " : prod_MZypUxgOcpUq6Z";
    }

}
