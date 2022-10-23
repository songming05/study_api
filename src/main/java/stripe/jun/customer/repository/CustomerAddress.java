package stripe.jun.customer.repository;

/**
 * CustomerEntity 에 넣고싶은데 (질문사항이라 주석삭제 x)
 */
public class CustomerAddress {

    public final String customerCity;
    public final String customerCountry;

    public CustomerAddress(String customerCity, String customerCountry) {
        this.customerCity = customerCity;
        this.customerCountry = customerCountry;
    }
}
