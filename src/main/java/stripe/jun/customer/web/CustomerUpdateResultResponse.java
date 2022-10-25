package stripe.jun.customer.web;

import stripe.jun.customer.service.CustomerUpdateResult;

public class CustomerUpdateResultResponse {

    public final String customerId;
    public final String customerName;
    public final String customerPhone;
    public final String customerDescription;

    public CustomerUpdateResultResponse(CustomerUpdateResult customerUpdateResult) {
        this.customerId = customerUpdateResult.customerId;
        this.customerName = customerUpdateResult.customerName;
        this.customerPhone = customerUpdateResult.customerPhone;
        this.customerDescription = customerUpdateResult.customerDescription;
    }
}
