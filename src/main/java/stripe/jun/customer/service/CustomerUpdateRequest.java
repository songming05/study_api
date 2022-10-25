package stripe.jun.customer.service;

import stripe.jun.customer.web.CustomerUpdateDto;

public class CustomerUpdateRequest {

    public final String customerId;
    public final String customerName;
    public final String customerPhone;
    public final String customerDescription;

    public CustomerUpdateRequest(String customerId, String customerName, String customerPhone, String customerDescription) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerDescription = customerDescription;
    }
}
