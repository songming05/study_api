package stripe.jun.customer.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerRepository {

    private Map<String, CustomerEntity> database = new HashMap<>();

    public void save(CustomerEntity entity) {
        if (database.containsKey(entity.customerId)) {
            throw new RuntimeException("이미 생성된 Id가 있습니다.");
        }
        database.put(entity.customerId, entity);
    }
}
