package stripe.jun.customer.web;

import stripe.jun.customer.service.Customer;

public class CustomerRetrieveResultResponse {
    /**
     * Id 만 해보자
     */
    public String id;

    public CustomerRetrieveResultResponse(Customer customer) {
        this.id = customer.id.value;
    }
}
