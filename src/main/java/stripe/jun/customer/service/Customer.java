package stripe.jun.customer.service;

import stripe.jun.customer.common.CustomerAddress;
import stripe.jun.customer.common.CustomerId;
import stripe.jun.customer.common.CustomerShipping;

import java.time.LocalDateTime;

/**
 * Customer 객체
 */
public class Customer {
    public CustomerId id;

    /**
     * The customer’s address.
     */
    public CustomerAddress customerAddress;

    /**
     * An arbitrary string attached to the object. Often useful for displaying to users.
     */
    public String description;

    /**
     * The customer’s email address.
     */
    public String email;

    /*Set of key-value pairs that you can attach to an object.
    This can be useful for storing additional information about the object in a structured format.*/
//    public Map<String, Object> metadata;

    public String name;

    public String phone;

    public CustomerShipping customershipping;

    public Boolean valid;

    public LocalDateTime createdTime;

    public Customer(CustomerId id, CustomerAddress customerAddress, String description, String email, String name, String phone, CustomerShipping customershipping, Boolean valid, LocalDateTime createdTime) {
        this.id = id;
        this.customerAddress = customerAddress;
        this.description = description;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.customershipping = customershipping;
        this.valid = valid;
        this.createdTime = createdTime;
    }
}
