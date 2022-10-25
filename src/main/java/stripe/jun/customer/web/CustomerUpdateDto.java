package stripe.jun.customer.web;

public class CustomerUpdateDto {

    public final String customerName;
    public final String customerPhone;
    public final String customerDescription;

    public CustomerUpdateDto(String customerName, String customerPhone, String customerDescription) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerDescription = customerDescription;
    }
}
