package stripe.jun.customer.common;

/**
 * Mailing and shipping address for the customer.
 * Appears on invoices emailed to this customer.
 */
public class CustomerShipping {
    CustomerAddress address;

    public String name;

    public String phone;

    public CustomerShipping(CustomerAddress address, String name, String phone) {
        this.address = address;
        this.name = name;
        this.phone = phone;
    }
}
