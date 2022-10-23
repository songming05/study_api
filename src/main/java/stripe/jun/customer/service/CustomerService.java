package stripe.jun.customer.service;

import org.springframework.stereotype.Service;
import stripe.jun.customer.repository.CustomerEntity;
import stripe.jun.customer.repository.CustomerRepository;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    private final CustomerIdGenerator customerIdGenerator;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerIdGenerator customerIdGenerator, CustomerRepository customerRepository) {
        this.customerIdGenerator = customerIdGenerator;
        this.customerRepository = customerRepository;
    }

    public Customer create(CustomerCreationRequest customerCreationRequest) {
        String customerId = customerIdGenerator.generateCustomerId();

        CustomerEntity customerEntity = new CustomerEntity(customerId,
                customerCreationRequest.customerName,
                customerCreationRequest.customerPhone,
                customerCreationRequest.customerDescription,
                LocalDateTime.now());

        customerRepository.save(customerEntity);

        return new Customer(customerId,
                customerEntity.customerName,
                customerEntity.customerPhone,
                customerEntity.customerDescription,
                customerEntity.customerCreatedTime);

    }
}