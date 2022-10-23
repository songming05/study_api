package stripe.jun.customer.service;

/**
 * Service 계층에서 사용하는 Customer 생성요청 객체
 */
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
