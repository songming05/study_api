package stripe.jun.customer.service;

import stripe.jun.customer.repository.CustomerAddress;

import java.time.LocalDateTime;

/**
 * Service 계층에서 사용하는 Customer 객체
 */
public class Customer {

    public final String customerId;
    public final String customerName; /** 사용자 이름 */
    public final String customerPhone; /** 사용자 휴대전화번호 */
    //public final CustomerAddress customerAddress; /**사용자 주소 */
    public final String customerDescription; /** someone@example.com for Coderwall" 사용자에대한 부가적인 설명(소개란정도)*/

    public final LocalDateTime customerCreatedTime; /**생성시각 */

    public Customer(String customerId, String customerName, String customerPhone, String customerDescription, LocalDateTime customerCreatedTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerDescription = customerDescription;
        this.customerCreatedTime = customerCreatedTime;
    }
}
