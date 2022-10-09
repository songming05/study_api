package stripe.jun.customer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import stripe.jun.customer.common.CustomerId;
import stripe.jun.customer.service.Customer;
import stripe.jun.customer.service.CustomerService;

@RestController
public class CustomerController {

    /**
     * @RequiredArgsConstructor
     */
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("api/v1/customer/{id}")
    public CustomerRetrieveResultResponse retrieveCoupon(@PathVariable  String id) {
        CustomerId customerId = new CustomerId(id);

        Customer customer = customerService.retrieve(customerId);

        return new CustomerRetrieveResultResponse(customer);
    }

//    @GetMapping("api/v1/customer/{id}")
//    public String retrieveCoupon(@PathVariable  String id) {
//        return id + " : cus_8eqdcH07DUqA5s";
//    }
}
