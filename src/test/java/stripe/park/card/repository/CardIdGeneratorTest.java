package stripe.park.card.repository;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stripe.park.card.service.CardIdGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CardIdGeneratorTest {

    String generatedId = new CardIdGenerator().generate();

    @Test
    @DisplayName("카드 Id 생성 테스트")
    void test() {
        String prefix = generatedId.substring(0, 5);

        assertThat(prefix).isEqualTo("card_");
        assertThat(generatedId.substring(5)).matches("[a-zA-Z0-9]*");
        assertThat(generatedId.length()).isEqualTo(29);

    }
}
