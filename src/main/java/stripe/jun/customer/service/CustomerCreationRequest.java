package stripe.jun.customer.service;

public class CustomerCreationRequest {

    public final String customerName;
    public final String customerPhone;
//    public final String customerCity;
//    public final String customerCountry;
    public final String customerDescription;

    public CustomerCreationRequest(String customerName, String customerPhone, String customerDescription) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerDescription = customerDescription;
    }
}
