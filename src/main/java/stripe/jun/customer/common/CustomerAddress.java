package stripe.jun.customer.common;

/**
 * Customer 주소
 */
public class CustomerAddress {
    public String city;

    public String country;

    public String line1;

    public String line2;

    public String postal_code;

    public String state;

    public CustomerAddress(String city, String country, String line1, String line2, String postal_code, String state) {
        this.city = city;
        this.country = country;
        this.line1 = line1;
        this.line2 = line2;
        this.postal_code = postal_code;
        this.state = state;
    }
}
