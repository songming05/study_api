package stripe.jun.customer.repository;

/**
 * CustomerEntity 에 넣고싶은데
 */
public class CustomerAddress {

    public final String customerCity; /** 사용자가 거주 중인 도시 */
    public final String customerCountry; /** 사용자가 거주 중인 국가 */

    public CustomerAddress(String customerCity, String customerCountry) {
        this.customerCity = customerCity;
        this.customerCountry = customerCountry;
    }
}
