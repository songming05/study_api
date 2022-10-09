package stripe.jun.customer.service;

import org.springframework.stereotype.Service;
import stripe.jun.customer.common.CustomerId;
import stripe.jun.customer.storage.CustomerEntity;
import stripe.jun.customer.storage.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * search Customer Id
     * Customer
     * @param id
     * @return
     */
    public Customer retrieve(CustomerId id) {
        CustomerEntity entity = customerRepository.retrieve(id);
        return new Customer(entity.id, entity.customerAddress, entity.description, entity.email, entity.name, entity.phone, entity.customershipping, entity.valid, entity.createdTime);
    }
}
