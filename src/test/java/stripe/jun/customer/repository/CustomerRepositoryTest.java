package stripe.jun.customer.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stripe.jun.customer.service.CustomerIdGenerator;

import static org.assertj.core.api.Assertions.assertThat;


class CustomerRepositoryTest {

    String customerId = new CustomerIdGenerator().generateCustomerId();

    @Test
    @DisplayName("Customer Id 생성 테스트")
    void customerIdGeneratorTest() {

        assertThat(customerId.length()).isEqualTo(18);
        assertThat(customerId.substring(0, 4)).isEqualTo("cus_");
        assertThat(customerId.substring(4)).containsPattern("[a-zA-Z0-9]*");
    }
}