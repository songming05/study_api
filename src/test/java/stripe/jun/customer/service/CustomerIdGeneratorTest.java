package stripe.jun.customer.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerIdGeneratorTest {

    String generateCustomerId = new CustomerIdGenerator().generateCustomerId();

    @Test
    @DisplayName("Customer Id 생성 테스트")
    void customerIdGeneratorTest() {

        assertThat(generateCustomerId.length()).isEqualTo(18);
        assertThat(generateCustomerId.substring(0, 4)).isEqualTo("cus_");
        assertThat(generateCustomerId.substring(4)).containsPattern("[a-zA-Z0-9]*");
    }
}