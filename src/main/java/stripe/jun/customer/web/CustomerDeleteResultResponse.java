package stripe.jun.customer.web;

import stripe.jun.customer.common.CustomerId;
import stripe.jun.customer.service.CustomerDeleteResult;

public class CustomerDeleteResultResponse {

    public final String customerId;

    public CustomerDeleteResultResponse(CustomerDeleteResult customerDeleteResult) {
        this.customerId = customerDeleteResult.customerId;
    }
}
