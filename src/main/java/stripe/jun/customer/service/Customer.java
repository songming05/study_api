package stripe.jun.customer.service;

import stripe.jun.customer.repository.CustomerAddress;

import java.time.LocalDateTime;

public class Customer {

    public final String customerId;
    public final String customerName;
    public final String customerPhone;
    //public final CustomerAddress customerAddress; /**사용자 주소 */
    public final String customerDescription;

    public final LocalDateTime customerCreatedTime;

    public Customer(String customerId, String customerName, String customerPhone, String customerDescription, LocalDateTime customerCreatedTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerDescription = customerDescription;
        this.customerCreatedTime = customerCreatedTime;
    }
}
