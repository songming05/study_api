package stripe.jun.customer.web;

public class CustomerRequestDto {

    public final String customerName;
    public final String customerPhone;
//    public final String customerCity;
//    public final String customerCountry;
    public final String customerDescription;

    public CustomerRequestDto(String customerName, String customerPhone, String customerDescription) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerDescription = customerDescription;
    }
}
