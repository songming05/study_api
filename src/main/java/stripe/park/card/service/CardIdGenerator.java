package stripe.park.card.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class CardIdGenerator {

    // id = card_1Lt4Ah2eZvKYlo2C9JYrQSaB
    private static final String CAPITAL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC = "0123456789";

    public String generate() {
        String prefix = "card_";

        String body = RandomStringUtils.randomAlphanumeric(24);

        return prefix + body;
    }
}
