package stripe.park.card.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class CardIdGenerator {

    // id = card_1Lt4Ah2eZvKYlo2C9JYrQSaB

    public String generate() {
        String prefix = "card_";

        String body = RandomStringUtils.randomAlphanumeric(24);

        return prefix + body;
    }
}
