package stripe.jun.customer.service;

import org.springframework.stereotype.Service;
import stripe.jun.customer.common.CustomerId;
import stripe.jun.customer.repository.CustomerEntity;
import stripe.jun.customer.repository.CustomerRepository;
import stripe.jun.customer.web.CustomerUpdateDto;

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

    public Customer retrieve(String id) {
        CustomerEntity customer = customerRepository.retrieve(id);

        return new Customer(customer.customerId,
                customer.customerName,
                customer.customerPhone,
                customer.customerDescription,
                customer.customerCreatedTime);
    }

    public CustomerDeleteResult delete(CustomerId customerId) {
        CustomerEntity customerEntity = customerRepository.delete(customerId);

        return new CustomerDeleteResult(customerEntity.customerId);
    }

    public CustomerUpdateResult update(CustomerUpdateRequest customerUpdateRequest) {
        CustomerId customerId = new CustomerId(customerUpdateRequest.customerId);

        CustomerEntity customerEntity = new CustomerEntity(customerId.customerId,
                customerUpdateRequest.customerName,
                customerUpdateRequest.customerPhone,
                customerUpdateRequest.customerDescription,
                LocalDateTime.now());

        CustomerEntity updateCustomerResult = customerRepository.update(customerEntity);

        return new CustomerUpdateResult(updateCustomerResult.customerId
                ,updateCustomerResult.customerName
                ,updateCustomerResult.customerPhone
                ,updateCustomerResult.customerDescription);
    }
}
