package stripe.jun.customer.storage;

import org.springframework.stereotype.Component;
import stripe.jun.customer.common.CustomerId;
import stripe.jun.customer.service.Customer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Component 어노테이션을 이용하면 Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있다.
 * 빈 등록자체를 빈 클래스 자체에다가 할 수 있다는 의미이다.
 * @Component 어노테이션은 기본적으로 타입기반의 자동주입 어노테이션이다.
 * @Autowired, @Resource와 비슷한 기능을 수행한다고 할 수 있겠다.
 */
@Component
public class CustomerRepository {
    private Map<String, CustomerEntity> database = new ConcurrentHashMap<>();  // db를 대체할 Map, 멀티쓰레드환경에서는 ConcurrentHashMap

    public CustomerEntity retrieve(CustomerId id) {
        System.out.println("id = " + id.value);
        System.out.println("database = " + database);
        //database.put("test", id.value);
        //database.put("1", );
        //CustomerEntity customer = database.get(id.value);
        //database.put("1", customer);

        CustomerEntity customer = new CustomerEntity();
        customer.setId(id);

        System.out.println("customer = " + customer);
        //CustomerEntity customer =
        return customer;
    }
}
