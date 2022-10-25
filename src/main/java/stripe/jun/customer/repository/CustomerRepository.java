package stripe.jun.customer.repository;

import org.springframework.stereotype.Component;
import stripe.jun.customer.common.CustomerId;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@Component
public class CustomerRepository {

    private Map<String, CustomerEntity> database = new HashMap<>();

    public void save(CustomerEntity entity) {
        if (database.containsKey(entity.customerId)) {
            throw new RuntimeException("이미 생성된 Id가 있습니다.");
        }
        database.put(entity.customerId, entity);
    }

    public CustomerEntity retrieve(String id) {
        CustomerEntity customerEntity = database.get(id);
        if (customerEntity == null) {
            throw new IllegalArgumentException("해당하는 Customer 가 없습니다. id ::: " + id);
        }

        return customerEntity;
    }

    public CustomerEntity delete(CustomerId customerId) {
        if (!database.containsKey(customerId.customerId)) {
            throw new IllegalArgumentException("해당하는 Customer 가 없습니다. id ::: " + customerId.customerId);
        }

        return database.remove(customerId.customerId);
    }

    public CustomerEntity update(CustomerEntity customerEntity) {
        if (database.containsKey(customerEntity.customerId)) {
            return database.put(customerEntity.customerId, customerEntity);
        } else {
            throw new IllegalArgumentException("해당하는 Customer 가 없습니다. id ::: " + customerEntity.customerId);
        }
    }
}
