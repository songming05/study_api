package stripe.jun.customer.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerIdGenerator {

    /**
     * cus_4QFHdAzXHKCFfn 18자리
     * implementation 'org.apache.commons:commons-lang3:3.12.0'
     */
    public String generateCustomerId() {
        String prefix = "cus_";

        String randomKey = RandomStringUtils.randomAlphanumeric(14);

        return prefix.concat(randomKey);
    }
}
