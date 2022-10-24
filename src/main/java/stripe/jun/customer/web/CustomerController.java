package stripe.jun.customer.web;

import org.springframework.web.bind.annotation.*;
import stripe.jun.customer.common.CustomerId;
import stripe.jun.customer.service.Customer;
import stripe.jun.customer.service.CustomerCreationRequest;
import stripe.jun.customer.service.CustomerDeleteResult;
import stripe.jun.customer.service.CustomerService;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("api/v1/customers")
    public CustomerCreatedResultResponse createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {

        Customer customer = customerService.create(new CustomerCreationRequest(customerRequestDto.customerName, customerRequestDto.customerPhone, customerRequestDto.customerDescription));

        return new CustomerCreatedResultResponse(customer);
    }

    @GetMapping("api/v1/customers/{id}")
    public CustomerRetrieveResultResponse retrieveCustomer(@PathVariable String id) {
        customerService.retrieve(id);

        return new CustomerRetrieveResultResponse(id);
    }

    @DeleteMapping("api/v1/customers/{id}")
    public CustomerDeleteResultResponse deleteCustomer(@PathVariable String id) {

        CustomerId customerId = new CustomerId(id);

        CustomerDeleteResult customerDeleteResult = customerService.delete(customerId);

        return new CustomerDeleteResultResponse(customerDeleteResult);
    }
}
