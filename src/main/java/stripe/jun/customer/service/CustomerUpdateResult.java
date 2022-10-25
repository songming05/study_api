package stripe.jun.customer.service;

public class CustomerUpdateResult {

    public final String customerId;
    public final String customerName;
    public final String customerPhone;
    public final String customerDescription;

    public CustomerUpdateResult(String customerId, String customerName, String customerPhone, String customerDescription) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerDescription = customerDescription;
    }
}
