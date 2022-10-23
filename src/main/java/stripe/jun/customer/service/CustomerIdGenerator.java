package stripe.jun.customer.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerIdGenerator {

    public String generateCustomerId() {
        String prefix = "cus_";

        String randomKey = RandomStringUtils.randomAlphanumeric(14);

        return prefix.concat(randomKey);
    }
}
