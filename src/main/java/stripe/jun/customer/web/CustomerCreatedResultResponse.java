package stripe.jun.customer.web;

import stripe.jun.customer.service.Customer;

import java.time.LocalDateTime;

public class CustomerCreatedResultResponse {
    public final String customerId;
    public final LocalDateTime localDateTime;

    public CustomerCreatedResultResponse(Customer customer) {
        this.customerId = customer.customerId;
        this.localDateTime = customer.customerCreatedTime;
    }
}
