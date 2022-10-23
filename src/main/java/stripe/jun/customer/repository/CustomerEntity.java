package stripe.jun.customer.repository;

import java.time.LocalDateTime;

public class CustomerEntity {

    public final String customerId;
    public final String customerName;
    public final String customerPhone;
    //public final CustomerAddress customerAddress; /**사용자 주소 */
    public final String customerDescription;

    public final LocalDateTime customerCreatedTime;

    public CustomerEntity(String customerId, String customerName, String customerPhone, String customerDescription, LocalDateTime customerCreatedTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        //this.customerAddress = customerAddress;
        this.customerDescription = customerDescription;
        this.customerCreatedTime = customerCreatedTime;
    }
}
