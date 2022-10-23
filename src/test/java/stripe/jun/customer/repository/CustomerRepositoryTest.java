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

        assertThat(customerId.length()).isEqualTo(18); /** CustomerId 는 18자리 이어야 한다. */
        assertThat(customerId.substring(0, 4)).isEqualTo("cus_"); /** CustomerId 의 앞 4글자는 cus_ 고정이다. */
        assertThat(customerId.substring(4)).containsPattern("[a-zA-Z0-9]*"); /** CustomerId 의 5번째는 영어소문자, 대문자, 숫자식으로 이루어져 있어야 한다.*/
    }
}