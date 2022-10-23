package stripe.jun.customer.web;

/**
 * Create a customer 에서는 다양한 정보들을 요청하지만, 이해할 수 있는 것만 해보려고 줄임.
 */
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
