package stripe.jun.customer.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * @Component 어노테이션을 이용하면 Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있다.
 * 빈 등록자체를 빈 클래스 자체에다가 할 수 있다는 의미이다.
 *
 * https://programmingrecoding.tistory.com/13
 */
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
            throw new IllegalArgumentException("해당하는 Customer 가 없습니다. id ::: " + id); /** java.lang.IllegalArgumentException은 적합하지 않거나(illegal) 적절하지 못한(inappropriate) 인자를 메소드에 넘겨주었을 때 발생합니다. */
        }

        return customerEntity;
    }
}
