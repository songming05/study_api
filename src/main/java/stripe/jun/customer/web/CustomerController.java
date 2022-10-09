package stripe.jun.customer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("api/v1/customer/{id}")
    public String retrieveCustomer(@PathVariable String id) {
        return id + " : cus_8eqdcH07DUqA5s";
    }
}
